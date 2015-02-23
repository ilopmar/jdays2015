package jdays.photo

import groovy.json.JsonBuilder

class BrowserPushService {
    static transactional = false

    def brokerMessagingTemplate

    Photo pushToBrowser(Photo photo) {
        log.debug "Pushing file to browser: ${photo.output}"

        String imageB64 = new File(photo.output).bytes.encodeBase64().toString()

        def builder = new JsonBuilder()
        builder {
            image(imageB64)
        }

        brokerMessagingTemplate.convertAndSend "/topic/photos", builder

        return photo
    }
}