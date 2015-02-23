package jdays.photo

import org.im4java.core.ConvertCmd
import org.im4java.core.IMOperation

class ImageConverterService {

    def rnd = new Random()

    Photo applyEffect(Photo photo) {
        log.debug "Applying effect to file: ${photo.input}..."

        def inputFile = photo.input
        def outputFile = photo.output

        def polaroidRotation = rnd.nextInt(6)

        def op = new IMOperation()
        op.addImage(inputFile)
        op.thumbnail(260, 260)
            .set("caption", "jDays 2015")
            .gravity("center")
            .pointsize(16)
            .background("black")
            .polaroid(rnd.nextBoolean() ? polaroidRotation : -polaroidRotation)
            .addImage(outputFile)

        def command = new ConvertCmd()
        command.run(op)

        return photo
    }
}