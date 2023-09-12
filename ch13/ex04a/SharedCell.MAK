ORIGIN		= Symantec Café Lite
ORIGIN_VER	= Version 7.22
VERSION		= DEBUG

!IFDEF SUB_DEBUG
DEBUG		= $(SUB_DEBUG)
NDEBUG		= !$(SUB_DEBUG)
!ELSE
DEBUG		= 1
NDEBUG		= 0
!ENDIF

PROJ		= SharedCell
APPTYPE		= JAVA APPLET
PROJTYPE	= class

JAVAC		= javac
MAKE		= SMAKE
LNK		= LINK


HEADERS		= 
!IF $(DEBUG)
OUTPUTDIR	= .
CREATEOUTPUTDIR	=
TARGETDIR	= .
CREATETARGETDIR	=

CFLAGS		=  -g 
DEFINES		= 
!ELSE
OUTPUTDIR	= .
CREATEOUTPUTDIR	=
TARGETDIR	= .
CREATETARGETDIR	=

CFLAGS		=  -O 
DEFINES		= 
!ENDIF

MFLAGS		= MASTERPROJ=$(PROJ) 
DEBUGGERFLAGS	=  
PAR		= PROJS BATS OBJS

INCLUDES	= 



OBJS		= SharedCell.class 

BATS		= 

.SUFFIXES: .JAVA .CLASS 

.JAVA.CLASS:
	$(JAVAC) $(CFLAGS) $(INCLUDES) $*.java



all:	noteout createdir $(PRECOMPILE) $(OBJS) $(POSTCOMPILE) _done


all2:	createdir $(PRECOMPILE) $(OBJS) $(POSTCOMPILE) _done

noteout:
	REM Output to $(OUTPUTDIR)

createdir:
	$(CREATEOUTPUTDIR)
	$(CREATETARGETDIR)
	
_done:
		REM  Project is up to date

buildall:	clean	all


clean:
		-del $(TARGETDIR)\$$SCW$$.$(PROJTYPE)
		-del $(TARGETDIR)\$(PROJ).CLE
		-del SharedCell.dpd
		-del $(OBJS)



!IF EXIST (SharedCell.dpd)
!INCLUDE SharedCell.dpd
!ENDIF

