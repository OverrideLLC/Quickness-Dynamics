package org.quickness.dynamics.plataform

import java.awt.Desktop
import java.net.URI

actual class Uri actual constructor() {
    actual fun navigate(uri: String) {
        Desktop.getDesktop().browse(URI.create(uri))
    }
}