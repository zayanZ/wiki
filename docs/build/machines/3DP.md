# 3D Printers

Our CAD team mainly uses our 3d printers to prototype parts which will later go on the robot. We use the MakerBot Replicator 2. You can download the slicer [here](https://s	upport.makerbot.com/s/article/MakerBot-Desktop-Download). 

In order to export files from Fusion to the MakerBot slicer, first save your file. You can save your file by pressing the floppy disk icon in the top left, right above the **Design** tab. Next, right click the largest header in the **Browser** tab in the top left. It should be named whatever the file is named as, followed by v(Number). Next, press save as mesh, set the format to **STL (Binary)**. Structure and refinement should be set to **One File** and **Medium**, respectively. In order to export a file from Fusion directly to your slicer, check the box which says **Send to 3d Print Utility**. Next select **MakerBot** from the dropdown. Now, your file should be in the MakerBot slicer. 

Once your file is into the slicer, first make sure there are no overhangs which will need supports. If there are, try and rotate the object in different directions to minimize supports. If you have to use supports, press **Settings** in the toolbar, select **Supports and Bridging**, and check off the first box. Next, make sure that the temperature is set to 210ºC, which can be adjusted in **Device Settings**.  

Now, you’re ready to export! First preview the model to make sure nothings wrong. Then press **Export**, and name the file with CamelCase, and name it something that relates to the part you are printing, like cameraMountv1 if its your first time printing that model. If any updates are made to the design, next time you export, name it cameraMountv2, just to help stay organized. Make sure the file you are exporting is a .x3g. 

Next, plug in the SD card, and drag the file into the SD card. You’re almost ready to print. From here, turn on the printer. Then preheat the nozzle, and in utilities, select **Load**. The screen will tell you when you can start pushing the filament through. 

Once the filament is in and running through the nozzle, insert your SD card into the slot and select your file. Once the print finishes, take it off with a scraper and now you’re all set!
