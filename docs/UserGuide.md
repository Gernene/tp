---
layout: page
title: User Guide
---

TAssist is a **desktop app for managing students and their participation in lessons, optimized for use via a Command Line Interface** (CLI). If you are a TA  who prefer CLI to GUI while having a GUI to view the student data, TAssist is the app for you.
 
* Table of Contents
{:toc}

--------------------------------------------------------------------------------------------------------------------

## Quick start

1. Ensure you have Java `11` or above installed in your Computer.

1. Download the latest `TAssist.jar` from [here](https://github.com/AY2122S2-CS2103T-T13-2/tp/releases).

1. Copy the file to the folder you want to use as the _home folder_ for your TAssist.

1. Double-click the file to start the app. The GUI similar to the below should appear in a few seconds. Note how the app contains some sample data.<br>
   ![Ui](images/Ui.png)

1. Type the command in the command box and press Enter to execute it. e.g. typing **`list student`** and pressing Enter will list all students added.<br>
   Some example commands you can try:

   * **`list student`** : Lists all students.

   * **`add student`**`id/E0123456 n/John Doe p/98765432 e/johnd@example.com` : Adds a student named `John Doe` to the TAssist.

   * **`delete student`**`3` : Deletes the 3rd student shown in the listing of the entity.

1. Refer to the [Features](#features) below for details of each command.

--------------------------------------------------------------------------------------------------------------------

## Features

<div markdown="block" class="alert alert-info">

**:information_source: Notes about the command format:**<br>

* Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  e.g. in `add n/NAME`, `NAME` is a parameter which can be used as `add n/John Doe`.

* Items in square brackets are optional.<br>
  e.g. `n/NAME [t/TAG]` can be used as `n/John Doe t/friend` or as `n/John Doe`.

* Items with `…`​ after them can be used multiple times including zero times.<br>
  e.g. `[t/TAG]…​` can be used as ` ` (i.e. 0 times), `t/friend`, `t/friend t/family` etc.

* Parameters can be in any order.<br>
  e.g. if the command specifies `n/NAME p/PHONE_NUMBER`, `p/PHONE_NUMBER n/NAME` is also acceptable.

* If a parameter is expected only once in the command, but you specified it multiple times, only the last occurrence of the parameter will be taken.<br>
  e.g. if you specify `p/12341234 p/56785678`, only `p/56785678` will be taken.

* Extraneous parameters for commands that do not take in parameters (such as `help`, `list`, `exit` and `clear`) will be ignored.<br>
  e.g. if the command specifies `help 123`, it will be interpreted as `help`.

</div>

### Viewing help : `help`

Shows a message explaining how to access the help page.

![help message](images/helpMessage.png)

Format: `help`

### Adding entries

#### Adding a student: `add student`

Adds a student to TAssist.

Format: `add student id/STUDENT_ID n/NAME p/PHONE_NUMBER e/EMAIL`

Examples:
* `add student id/E0123456 n/John Doe p/98765432 e/johnd@example.com`

#### Adding a module: `add module`

Adds a module to TAssist.

Format: `add module n/MODULE_NAME c/MODULE_CODE`

Examples:
* `add module n/Software Engineering Project c/CS2103T`

#### Adding a class group: `add class`

Adds a class group to TAssist.

Format: `add class id/CLASSGROUP_ID t/CLASSGROUP_TYPE m/MODULE_CODE`

Examples:
* `add class id/T13 t/tutorial m/CS2103T`

### Listing entries

#### Listing all persons : `list`

Shows a list of all persons in the address book.

Format: `list`

### Editing entries : `edit` [coming soon]

Edits an existing entry in TAssist.

Format: `edit INDEX [n/NAME] [p/PHONE] [e/EMAIL] [a/ADDRESS] [t/TAG]…​`

* Edits the person at the specified `INDEX`. The index refers to the index number shown in the displayed person list. The index **must be a positive integer** 1, 2, 3, …​
* At least one of the optional fields must be provided.
* Existing values will be updated to the input values.
* When editing tags, the existing tags of the person will be removed i.e. adding of tags is not cumulative.
* You can remove all the person’s tags by typing `t/` without
    specifying any tags after it.

Examples:
*  `edit 1 p/91234567 e/johndoe@example.com` Edits the phone number and email address of the 1st person to be `91234567` and `johndoe@example.com` respectively.
*  `edit 2 n/Betsy Crower t/` Edits the name of the 2nd person to be `Betsy Crower` and clears all existing tags.

### Locating entries: `find` [coming soon]

Finds persons whose names contain any of the given keywords.

Format: `find KEYWORD [MORE_KEYWORDS]`

* The search is case-insensitive. e.g. `hans` will match `Hans`
* The order of the keywords does not matter. e.g. `Hans Bo` will match `Bo Hans`
* Only the name is searched.
* Only full words will be matched e.g. `Han` will not match `Hans`
* Persons matching at least one keyword will be returned (i.e. `OR` search).
  e.g. `Hans Bo` will return `Hans Gruber`, `Bo Yang`

Examples:
* `find John` returns `john` and `John Doe`
* `find alex david` returns `Alex Yeoh`, `David Li`<br>
  ![result for 'find alex david'](images/findAlexDavidResult.png)

### Deleting entries

#### Deleting a student : `delete student`

Deletes the specified student from TAssist.

Format: `delete student INDEX`

* Deletes the student at the specified `INDEX`.
* The index refers to the index number shown in the displayed student list.
* The index **must be a positive integer** 1, 2, 3, …​

Examples:
* `list student` followed by `delete student 2` deletes the 2nd student in TAssist.

#### Deleting a module : `delete module`

Deletes the specified module from TAssist.

Format: `delete module INDEX`

* Deletes the module at the specified `INDEX`.
* The index refers to the index number shown in the displayed module list.
* The index **must be a positive integer** 1, 2, 3, …​

Examples:
* `list module` followed by `delete module 2` deletes the 2nd module in TAssist.

#### Deleting a class group : `delete class`

Deletes the specified class group from TAssist.

Format: `delete class INDEX`

* Deletes the class group at the specified `INDEX`.
* The index refers to the index number shown in the displayed class groups list.
* The index **must be a positive integer** 1, 2, 3, …​

Examples:
* `list class` followed by `delete class 2` deletes the 2nd class group in TAssist.

### Clearing all entries : `clear`

Clears all entries from the address book.

Format: `clear`

### Exiting the program : `exit`

Exits the program.

Format: `exit`

### Saving the data

TAssist data are saved in the hard disk automatically after any command that changes the data. There is no need to save manually.

### Editing the data file

TAssist data are saved as a JSON file `[JAR file location]/data/tassist.json`. Advanced users are welcome to update data directly by editing that data file.

<div markdown="span" class="alert alert-warning">:exclamation: **Caution:**
If your changes to the data file makes its format invalid, TAssist will discard all data and start with an empty data file at the next run.
</div>

### Archiving data files `[coming in v2.0]`

_Details coming soon ..._

--------------------------------------------------------------------------------------------------------------------

## FAQ

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous TAssist home folder.

--------------------------------------------------------------------------------------------------------------------

## Command summary

Action | Format, Examples
--------|------------------
**Add** | Adding student<ul><li>syntax: `add student id/STUDENT_ID n/NAME p/PHONE_NUMBER e/EMAIL` </li><li>e.g., `add student id/E0123456 n/John Doe p/98765432 e/johnd@example.com`</li></ul>Adding module<ul><li>syntax: `add module n/MODULE_NAME c/MODULE_CODE` </li><li>e.g., `add module n/Software Engineering Project c/CS2103T`</li></ul>Adding class group<ul><li>syntax: `add class id/CLASSGROUP_ID t/CLASSGROUP_TYPE m/MODULE_CODE` </li><li>e.g., `add class id/T13 t/tutorial m/CS2103T`</li></ul>
**Delete** | Deleting student<ul><li>syntax: `delete student INDEX` </li><li>e.g., `delete student 2`</li></ul>Deleting module<ul><li>syntax: `delete module INDEX` </li><li>e.g., `delete module 2`</li></ul>Deleting class group<ul><li>syntax: `delete class INDEX` </li><li>e.g., `delete class 2`</li></ul>
**List** | Listing students<ul><li>syntax: `list student` </li></ul>Listing modules<ul><li>syntax: `list module` </li></ul>Listing class groups<ul><li>syntax: `list class` </li></ul>
