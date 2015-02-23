package jdays.photo

class FileService {

    Photo preprocessFile(File file) {
        String outputFile = File.createTempFile("output", ".png").path

        return new Photo(input: file.absolutePath, output: outputFile)
    }

    void deleteTempFiles(Photo photo) {
        [photo.input, photo.output].each { file ->
            log.debug "Deleting file: ${file}"
            new File(file).delete()
        }
    }
}