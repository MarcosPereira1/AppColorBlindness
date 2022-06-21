package com.example.appcolorblindness.ui.fragments

import android.content.ActivityNotFoundException
import android.content.ContentValues
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.text.format.DateFormat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.FileProvider
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.appcolorblindness.BuildConfig
import com.example.appcolorblindness.R
import com.example.appcolorblindness.data.constants.ColorBlindnessConstants
import com.example.appcolorblindness.data.preferences.ColorBlindnessData
import com.example.appcolorblindness.databinding.FragmentFeedbackFailBinding
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.OutputStream
import java.util.*

class FeedbackFailFragment: Fragment() {
    private lateinit var binding: FragmentFeedbackFailBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFeedbackFailBinding.inflate(inflater, container, false)
        navigationToChooseGame()
        setResultTest()
        saveResult()

        return binding.root
    }

    private fun navigationToChooseGame() {
        binding.ibArrowBackChooseGame.setOnClickListener {
            findNavController().navigate(R.id.action_fragFeedbackFail_to_fragAgeGroup)
        }
    }

    private fun setResultTest() {
        val response = arguments?.getString(ColorBlindnessConstants.RESPONSE_USER)
        ColorBlindnessData.readCorrectQuestions(requireContext())
        val feedback = "Você acertou $response de ${ColorBlindnessData.readQuestions(requireContext())} testes"
        binding.tvFeedback.text = feedback
    }

    private fun saveResult() {
        binding.btnShareFeedback.setOnClickListener {
            takeScreenShot(activity?.window?.decorView)
        }
    }

    private fun takeScreenShot(view: View?) {
        // Isto é usado para fornecer o nome do arquivo com o formato Date.
        val date = Date()
        val format = DateFormat.format("MM-dd-yyyy_hh:mm:ss", date)

        // Ele se certificará de armazenar o arquivo abaixo do Directory e se o arquivo Directory dosen não existir, então ele o criará.
        try {
            val mainDir = File(
                requireContext().getExternalFilesDir(Environment.DIRECTORY_SCREENSHOTS), "AppColorBlindness"
            )
            if (!mainDir.exists()) {
                val mkdir = mainDir.mkdir()
            }

            //Fornecimento do nome do arquivo junto com o Bitmap para capturar a visualização da tela
            val path = "$mainDir/AppColorBlindness-$format.jpeg"
            view?.isDrawingCacheEnabled = true
            val bitmap = view?.drawingCache?.let { Bitmap.createBitmap(it) }
            view?.isDrawingCacheEnabled = false

            // Esta lógica é usada para salvar o arquivo em determinado local com o nome do arquivo dado e comprimir a Qualidade da Imagem.
            val imageFile = File(path)
            val fileOutputStream = FileOutputStream(imageFile)
            bitmap?.compress(Bitmap.CompressFormat.PNG, 90, fileOutputStream)
            bitmap?.let { saveMediaToStorage(it) }
            fileOutputStream.flush()
            fileOutputStream.close()

            // Criar um novo método para tirar ScreenShot com o imageFile.
            shareScreenShot(imageFile)
        } catch (e: IOException) {
            e.printStackTrace()
        }

    }

    //Compartilhar ScreenShot
    private fun shareScreenShot(imageFile: File) {
        // Usando subclasse de fornecedor de conteúdoer
        val uri: Uri? = context?.let {
            FileProvider.getUriForFile(
                it,
                BuildConfig.APPLICATION_ID + ".provider",
                imageFile
            )
        }
        //Intent Explicita
        val intent = Intent()
        intent.action = Intent.ACTION_SEND
        intent.type = "image/*"
        intent.putExtra(
            Intent.EXTRA_TEXT,
            "Este é o resultado do teste de ${ColorBlindnessData.readUsername(requireContext())}"
        )
        intent.putExtra(Intent.EXTRA_STREAM, uri)

        //Ele mostrará a aplicação que está disponível para compartilhar imagem; caso contrário, a mensagem de torrada será lançada.
        try {
            this.startActivity(Intent.createChooser(intent, "Share With"))
        } catch (e: ActivityNotFoundException) {
            Toast.makeText(requireContext(), "No App Available", Toast.LENGTH_SHORT).show()
        }
    }

    private fun saveMediaToStorage(bitmap: Bitmap) {
        val filename = "${System.currentTimeMillis()}.jpg"

        // Output stream
        var fos: OutputStream? = null

        // For devices running android >= Q
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            // getting the contentResolver
            activity?.contentResolver?.also { resolver ->

                // Content resolver will process the contentvalues
                val contentValues = ContentValues().apply {

                    // putting file information in content values
                    put(MediaStore.MediaColumns.DISPLAY_NAME, filename)
                    put(MediaStore.MediaColumns.MIME_TYPE, "image/jpg")
                    put(MediaStore.MediaColumns.RELATIVE_PATH, Environment.DIRECTORY_PICTURES)
                }

                // Inserting the contentValues to
                // contentResolver and getting the Uri
                val imageUri: Uri? = resolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues)

                // Opening an outputstream with the Uri that we got
                fos = imageUri?.let { resolver.openOutputStream(it) }
            }
        } else {
            // These for devices running on android < Q
            val imagesDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)
            val image = File(imagesDir, filename)
            fos = FileOutputStream(image)
        }

        fos?.use {
            // Finally writing the bitmap to the output stream that we opened
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, it)
            Toast.makeText(requireContext() , "Resultado salvo na sua galeria de fotos." , Toast.LENGTH_SHORT).show()
        }
    }
}