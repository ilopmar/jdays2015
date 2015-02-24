package jdays.xmpp

class XmppController {

    def xmppService

    def chat(String msg) {
        msg = msg ?: "Hello jDays from Spring Integration XMPP!"

        xmppService.sendMessage(msg)

        render "Done!"
    }
}
