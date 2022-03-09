package seedu.address.model;

import java.nio.file.Path;
import java.util.function.Predicate;

import javafx.collections.ObservableList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.model.classgroup.ClassGroup;
import seedu.address.model.person.Person;
import seedu.address.model.tamodule.TaModule;

/**
 * The API of the Model component.
 */
public interface AB3Model {
    /** {@code Predicate} that always evaluate to true */
    Predicate<Person> PREDICATE_SHOW_ALL_PERSONS = unused -> true;

    /** {@code Predicate} that always evaluate to true */
    Predicate<TaModule> PREDICATE_SHOW_ALL_MODULES = unused -> true;

    /** {@code Predicate} that always evaluate to true */
    Predicate<ClassGroup> PREDICATE_SHOW_ALL_CLASS_GROUPS = unused -> true;

    /**
     * Replaces user prefs data with the data in {@code userPrefs}.
     */
    void setUserPrefs(ReadOnlyUserPrefs userPrefs);

    /**
     * Returns the user prefs.
     */
    ReadOnlyUserPrefs getUserPrefs();

    /**
     * Returns the user prefs' GUI settings.
     */
    GuiSettings getGuiSettings();

    /**
     * Sets the user prefs' GUI settings.
     */
    void setGuiSettings(GuiSettings guiSettings);

    /**
     * Returns the user prefs' address book file path.
     */
    Path getAddressBookFilePath();

    /**
     * Sets the user prefs' address book file path.
     */
    void setAddressBookFilePath(Path addressBookFilePath);

    /**
     * Replaces address book data with the data in {@code addressBook}.
     */
    void setAddressBook(ReadOnlyAddressBook addressBook);

    /** Returns the AddressBook */
    ReadOnlyAddressBook getAddressBook();

    /**
     * Returns true if a person with the same identity as {@code person} exists in the address book.
     */
    boolean hasPerson(Person module);

    /**
     * Deletes the given person.
     * The person must exist in the address book.
     */
    void deletePerson(Person target);

    /**
     * Adds the given person.
     * {@code person} must not already exist in the address book.
     */
    void addPerson(Person person);

    /**
     * Replaces the given person {@code target} with {@code editedTaModule}.
     * {@code target} must exist in the address book.
     * The person identity of {@code editedTaModule} must not be the same as another existing person in the address book.
     */
    void setPerson(Person target, Person editedPerson);

    /** Returns an unmodifiable view of the filtered person list */
    ObservableList<Person> getFilteredPersonList();

    /**
     * Updates the filter of the filtered person list to filter by the given {@code predicate}.
     * @throws NullPointerException if {@code predicate} is null.
     */
    void updateFilteredPersonList(Predicate<Person> predicate);

    /**
     * Returns true if a module with the same identity as {@code module} exists in the address book.
     */
    boolean hasModule(TaModule module);

    /**
     * Deletes the given person.
     * The person must exist in the address book.
     */
    void deleteModule(TaModule target);

    /**
     * Adds the given person.
     * {@code person} must not already exist in the address book.
     */
    void addModule(TaModule person);

    /**
     * Replaces the given person {@code target} with {@code editedModule}.
     * {@code target} must exist in the address book.
     * The person identity of {@code editedModule} must not be the same as another existing module in the address book.
     */
    void setModule(TaModule target, TaModule editedModule);

    /** Returns an unmodifiable view of the filtered person list */
    ObservableList<TaModule> getFilteredModuleList();

    /**
     * Updates the filter of the filtered person list to filter by the given {@code predicate}.
     * @throws NullPointerException if {@code predicate} is null.
     */
    void updateFilteredModuleList(Predicate<TaModule> predicate);

    /**
     * Returns true if a person with the same identity as {@code person} exists in the address book.
     */
    boolean hasClassGroup(ClassGroup classGroup);

    /**
     * Deletes the given person.
     * The person must exist in the address book.
     */
    void deleteClassGroup(ClassGroup target);

    /**
     * Adds the given person.
     * {@code person} must not already exist in the address book.
     */
    void addClassGroup(ClassGroup classGroup);

    /**
     * Replaces the given person {@code target} with {@code editedPerson}.
     * {@code target} must exist in the address book.
     * The person identity of {@code editedPerson} must not be the same as another existing person in the address book.
     */
    void setClassGroup(ClassGroup target, ClassGroup ediClassGroup);

    /** Returns an unmodifiable view of the filtered person list */
    ObservableList<ClassGroup> getFilteredClassGroupList();

    /**
     * Updates the filter of the filtered person list to filter by the given {@code predicate}.
     * @throws NullPointerException if {@code predicate} is null.
     */
    void updateFilteredClassGroupList(Predicate<ClassGroup> predicate);
}
