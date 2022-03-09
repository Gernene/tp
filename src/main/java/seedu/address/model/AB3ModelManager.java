package seedu.address.model;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.nio.file.Path;
import java.util.function.Predicate;
import java.util.logging.Logger;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.classgroup.ClassGroup;
import seedu.address.model.person.Person;
import seedu.address.model.tamodule.TaModule;

/**
 * Represents the in-memory model of the address book data.
 */
public class AB3ModelManager implements AB3Model {
    private static final Logger logger = LogsCenter.getLogger(AB3ModelManager.class);

    private final AddressBook addressBook;
    private final UserPrefs userPrefs;
    private final FilteredList<Person> filteredPersons;
    private final FilteredList<TaModule> filteredModules;
    private final FilteredList<ClassGroup> filteredClassGroups;

    /**
     * Initializes a ModelManager with the given addressBook and userPrefs.
     */
    public AB3ModelManager(ReadOnlyAddressBook addressBook, ReadOnlyUserPrefs userPrefs) {
        requireAllNonNull(addressBook, userPrefs);

        logger.fine("Initializing with address book: " + addressBook + " and user prefs " + userPrefs);

        this.addressBook = new AddressBook(addressBook);
        this.userPrefs = new UserPrefs(userPrefs);
        filteredPersons = new FilteredList<>(this.addressBook.getPersonList());
        filteredModules = new FilteredList<>(this.addressBook.getModuleList());
        filteredClassGroups = new FilteredList<>(this.addressBook.getClassGroupList());
    }

    public AB3ModelManager() {
        this(new AddressBook(), new UserPrefs());
    }

    //=========== UserPrefs ==================================================================================

    @Override
    public void setUserPrefs(ReadOnlyUserPrefs userPrefs) {
        requireNonNull(userPrefs);
        this.userPrefs.resetData(userPrefs);
    }

    @Override
    public ReadOnlyUserPrefs getUserPrefs() {
        return userPrefs;
    }

    @Override
    public GuiSettings getGuiSettings() {
        return userPrefs.getGuiSettings();
    }

    @Override
    public void setGuiSettings(GuiSettings guiSettings) {
        requireNonNull(guiSettings);
        userPrefs.setGuiSettings(guiSettings);
    }

    @Override
    public Path getAddressBookFilePath() {
        return userPrefs.getAddressBookFilePath();
    }

    @Override
    public void setAddressBookFilePath(Path addressBookFilePath) {
        requireNonNull(addressBookFilePath);
        userPrefs.setAddressBookFilePath(addressBookFilePath);
    }

    //=========== AddressBook ================================================================================

    @Override
    public void setAddressBook(ReadOnlyAddressBook addressBook) {
        this.addressBook.resetData(addressBook);
    }

    @Override
    public ReadOnlyAddressBook getAddressBook() {
        return addressBook;
    }

    @Override
    public boolean hasPerson(Person person) {
        requireNonNull(person);
        return addressBook.hasPerson(person);
    }

    @Override
    public void deletePerson(Person target) {
        addressBook.removePerson(target);
    }

    @Override
    public void addPerson(Person person) {
        addressBook.addPerson(person);
        updateFilteredPersonList(PREDICATE_SHOW_ALL_PERSONS);
    }

    @Override
    public void setPerson(Person target, Person editedPerson) {
        requireAllNonNull(target, editedPerson);

        addressBook.setPerson(target, editedPerson);
    }

    @Override
    public boolean hasModule(TaModule module) {
        requireNonNull(module);
        return addressBook.hasModule(module);
    }

    @Override
    public void deleteModule(TaModule target) {
        addressBook.removeModule(target);
    }

    @Override
    public void addModule(TaModule module) {
        addressBook.addModule(module);
        updateFilteredModuleList(PREDICATE_SHOW_ALL_MODULES);
    }

    @Override
    public void setModule(TaModule target, TaModule editedModule) {
        requireAllNonNull(target, editedModule);

        addressBook.setModule(target, editedModule);
    }

    @Override
    public boolean hasClassGroup(ClassGroup classGroup) {
        requireNonNull(classGroup);
        return addressBook.hasClassGroup(classGroup);
    }

    @Override
    public void deleteClassGroup(ClassGroup target) {
        addressBook.removeClassGroup(target);
    }

    @Override
    public void addClassGroup(ClassGroup classGroup) {
        addressBook.addClassGroup(classGroup);
        updateFilteredClassGroupList(PREDICATE_SHOW_ALL_CLASS_GROUPS);
    }

    @Override
    public void setClassGroup(ClassGroup target, ClassGroup editedClassGroup) {
        requireAllNonNull(target, editedClassGroup);

        addressBook.setClassGroup(target, editedClassGroup);
    }

    //=========== Filtered Person List Accessors =============================================================

    /**
     * Returns an unmodifiable view of the list of {@code Person} backed by the internal list of
     * {@code versionedAddressBook}
     */
    @Override
    public ObservableList<Person> getFilteredPersonList() {
        return filteredPersons;
    }

    @Override
    public void updateFilteredPersonList(Predicate<Person> predicate) {
        requireNonNull(predicate);
        filteredPersons.setPredicate(predicate);
    }

    //=========== Filtered Module List Accessors =============================================================

    /**
     * Returns an unmodifiable view of the list of {@code Person} backed by the internal list of
     * {@code versionedAddressBook}
     */
    @Override
    public ObservableList<TaModule> getFilteredModuleList() {
        return filteredModules;
    }

    @Override
    public void updateFilteredModuleList(Predicate<TaModule> predicate) {
        requireNonNull(predicate);
        filteredModules.setPredicate(predicate);
    }

    //=========== Filtered Class Group List Accessors =============================================================

    /**
     * Returns an unmodifiable view of the list of {@code Person} backed by the internal list of
     * {@code versionedAddressBook}
     */
    @Override
    public ObservableList<ClassGroup> getFilteredClassGroupList() {
        return filteredClassGroups;
    }

    @Override
    public void updateFilteredClassGroupList(Predicate<ClassGroup> predicate) {
        requireNonNull(predicate);
        filteredClassGroups.setPredicate(predicate);
    }

    @Override
    public boolean equals(Object obj) {
        // short circuit if same object
        if (obj == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(obj instanceof AB3ModelManager)) {
            return false;
        }

        // state check
        AB3ModelManager other = (AB3ModelManager) obj;
        return addressBook.equals(other.addressBook)
                && userPrefs.equals(other.userPrefs)
                && filteredPersons.equals(other.filteredPersons);
    }

}
