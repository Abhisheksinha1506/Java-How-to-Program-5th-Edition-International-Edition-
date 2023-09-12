This is the README file for 
Java How to Program with an Introduction to J++ 

Contents of this README:

-----------------------
J++
SOURCE CODE
APPLETS
LINKS
PROBLEMS RUNNING THE JAVA PROGRAMS
----------------------------------

J++
--------------
J++ is installed by running the setup program in the root directory.

----------------------------------

SOURCE CODE
--------------
Source Code is located in the 'code' directory.
Examples from the book are organized 
by chapter and example number.
----------------------------------

APPLETS
--------------
Applets can be launched by opening the 
file INDEX.HTML in the CODE 
directory with your Internet browser, 
then clicking on the appropriate example.
----------------------------------

LINKS
--------------
Links to other Java resources  can be launched by opening the 
file INDEX.HTML in the CODE 
directory with your Internet browser, 
then clicking on the appropriate example.
----------------------------------

PROBLEMS RUNNING THE JAVA PROGRAMS
----------------------------------

The Java programs, applets and applications may fail to execute 
for four separate reasons:

16-Bit Drivers
--------------
If the appletviewer or java window opens when you press 
the Execute icon, but the applet or application fails
to run, then your system is using older, 16-bit CD-ROM
drivers.  These older drivers truncate the long filenames 
(.class and .html) of java programs making it impossible for
the java virtual machine to find and execute them.

You can determine whether or not you have 16-bit drivers 
on your system by listing the contents of the directories
on the CD-ROM that contain the code samples.  These are in
the subdirectories in the \jhtp\code directory.  If they are
listed by Windows Explorer with ".jav" or ".cla" extensions,
then you have 16-bit drivers. If this is the case, contact 
your system manufacturer and ask for updated, 32-bit 
Windows 95 drivers.

TCP/IP Stack Required
---------------------
Java is a networked programming language.  Some of the 
objects defined in the Java Class Libraries require that
a TCP/IP stack be loaded in order to execute properly.
This is true of the applets in chapters 14 and 16.  If you are
working on a standalone system that is not connected to a
network or that does not have dial-up networking configured,
these applets will open but they will not execute properly.

MS-DOS Shell Properties
-------------------------------
Java programs that write to the system console
will work correctly from within the Cyber Classroom
only if the "Suggest MS-DOS mode as necessary" property 
is set for your MS-DOS sessions.  This is the default
setting, so unless you've changed it, this property will
be set correctly.

To set this property, do the following:

	1) Right-click on the MS-DOS prompt icon.  On most
	   systems, this icon is available under the Start 
	   Menu.  To access it, right-click on the Start 
	   button and select Open.  Double-click on the 
	   Programs icon, and right-click on the MS-DOS 
	   Prompt icon.

	2) Select Properties from the pop-up menu, and select
	   the Program tab.  

	3) Press the Advanced button.

	4) Check "Suggest MS-DOS mode as necessary" and press
	   OK.

Return to the application  and execute the program.

Case Sensitivity
---------------------
Because Java is a case sensitive language, you may encounter 
the following error message when attempting to build some of the
Java applets or applications from this CD:

C:\Msdev\code\ch08\Ex08_14\SORTTHEM.JAVA (9,8)
     error J0136: Public class 'SortThem'
     should not be defined in 'C:\Msdev\code\ch08\Ex08_14\SORTTHEM.JAVA'

If you get this message you will need to re-name the .java source file
to match exactly the name of the Public class in the file. For the example
shown you would need to re-name "SORTTHEM.JAVA" as "SortThem.java".
