package me.obsilabor.snippingtoolfix

import dorkbox.systemTray.MenuItem
import dorkbox.systemTray.SystemTray
import java.awt.Desktop
import java.net.URI
import java.net.URL
import javax.imageio.ImageIO
import kotlin.jvm.optionals.getOrNull
import kotlin.system.exitProcess

fun main() {
    if (!Desktop.isDesktopSupported()) {
        println("Headless environments aren't supported")
        exitProcess(0)
    }
    val tray = SystemTray.get("snipping-tool-fix")
    tray.installShutdownHook()
    runCatching {
        tray.setImage(ImageIO.read(URL("https://i.imgur.com/KxV3nxJ.png")))
    }
    tray.status = "Snipping Tool Fix"
    tray.menu.add(MenuItem("Fix") {
        ProcessHandle.allProcesses().toList().firstOrNull { (it.info().command().getOrNull() ?: "null").contains("ScreenClippingHost.exe") }?.destroy()
    })
    tray.menu.add(MenuItem("Fix Forcibly") {
        ProcessHandle.allProcesses().toList().firstOrNull { (it.info().command().getOrNull() ?: "null").contains("ScreenClippingHost.exe") }?.destroyForcibly()
    })
    tray.menu.add(MenuItem("Info") {
        Desktop.getDesktop().browse(URI("https://github.com/mooziii/snipping-tool-fix/blob/master/README.md"))
    })
    tray.menu.add(MenuItem("Quit") {
        tray.shutdown()
        exitProcess(0)
    })
}