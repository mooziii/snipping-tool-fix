# Archived as the issue has been fixed.

<p align="center">
    <img src="https://i.imgur.com/KxV3nxJ.png" width="128" height="128" style="align-content: center">
</p>
<h1 align="center">Snipping Tool Fix</h1>
<h5 align="center">A small Kotlin app to fix Snipping Tool not working on Windows 10</h5>

## What is this?

Some days ago I faced the problem that my Snipping Tool Hotkey wasn't working anymore. 
It turned out that the reason for that is, that the process "ScreenClippingHost.exe" isn't shutting down anymore.
So when I kill this process, everything works fine this time but the next time I tried to use the Hotkey, it wasn't working again because the 
ScreenClippingHost.exe process was running again. Seems like the process isn't closing correctly after the screenshot was done.


## How does this programm fix it?

**This programm adds a small system-tray icon from where you can kill the ScreenClippingHost.exe using a single-click.**
Yes, that's all. I was just too lazy to open my task manager, search for the process and kill it

![img_1.png](https://i.imgur.com/MxKps3N.png)
![img_2.png](https://i.imgur.com/Vj87vP9.png)

## Installation 

##### Requirements

* Java 16 or higher

Download the .jar file [here](https://github.com/mooziii/snipping-tool-fix/releases/download/1.0.0/snipping-tool-fix-1.0.0-all.jar)

If you want to automatically start the app on system-startup, press **Win + R**, type `shell:startup` and press **Enter**. Place the jar file in this folder.
Now the app will start on your next system boot. In case you want to start the app now, just execute the .jar file.
