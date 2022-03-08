package seedu.address.model;

import static java.util.Objects.requireNonNull;

import java.util.List;
import java.util.Objects;

import javafx.collections.ObservableList;
import seedu.address.model.classgroup.ClassGroup;
import seedu.address.model.classgroup.UniqueClassGroupList;
import seedu.address.model.student.Student;
import seedu.address.model.student.UniqueStudentList;
import seedu.address.model.tamodule.TaModule;
import seedu.address.model.tamodule.UniqueModuleList;

/**
 * Wraps all data at the TAssist level.
 * Duplicates are not allowed (by .isSameX comparison, where X is the corresponding entity).
 */
public class TAssist implements ReadOnlyTAssist {

    private final UniqueStudentList students;
    private final UniqueModuleList modules;
    private final UniqueClassGroupList classGroups;

    /*
     * The 'unusual' code block below is a non-static initialization block, sometimes used to avoid duplication
     * between constructors. See https://docs.oracle.com/javase/tutorial/java/javaOO/initial.html
     *
     * Note that non-static init blocks are not recommended to use. There are other ways to avoid duplication
     *   among constructors.
     */
    {
        students = new UniqueStudentList();
        modules = new UniqueModuleList();
        classGroups = new UniqueClassGroupList();
    }

    public TAssist() {
    }

    /**
     * Creates a TAssist using the lists in the {@code toBeCopied}.
     */
    public TAssist(ReadOnlyTAssist toBeCopied) {
        this();
        resetData(toBeCopied);
    }

    //// list overwrite operations

    /**
     * Replaces the contents of the student list with {@code students}.
     * {@code students} must not contain duplicate students.
     */
    public void setStudents(List<Student> students) {
        this.students.setStudents(students);
    }

    /**
     * Replaces the contents of the module list with {@code modules}.
     * {@code modules} must not contain duplicate modules.
     */
    public void setModules(List<TaModule> taModules) {
        this.modules.setModules(taModules);
    }

    /**
     * Replaces the contents of the class group list with {@code classGroups}.
     * {@code classGroups} must not contain duplicate class groups.
     */
    public void setClassGroups(List<ClassGroup> classGroups) {
        this.classGroups.setClassGroups(classGroups);
    }

    /**
     * Resets the existing data of this {@code TAssist} with {@code newData}.
     */
    public void resetData(ReadOnlyTAssist newData) {
        requireNonNull(newData);

        setStudents(newData.getStudentList());
        setModules(newData.getModuleList());
        setClassGroups(newData.getClassGroupList());
    }

    //// student-level operations

    /**
     * Returns true if a student with the same identity as {@code student} exists in the TAssist.
     */
    public boolean hasStudent(Student student) {
        requireNonNull(student);
        return students.contains(student);
    }

    /**
     * Adds a student to the TAssist.
     * The student must not already exist in the TAssist.
     */
    public void addStudent(Student student) {
        students.add(student);
    }

    /**
     * Replaces the given student {@code target} in the list with {@code editedStudent}.
     * {@code target} must exist in the TAssist.
     * The student identity of {@code editedStudent} must not be the same as another existing student in the TAssist.
     */
    public void setStudent(Student target, Student editedStudent) {
        requireNonNull(editedStudent);

        students.setStudent(target, editedStudent);
    }

    /**
     * Removes {@code key} from this {@code TAssist}.
     * {@code key} must exist in the TAssist.
     */
    public void removeStudent(Student key) {
        students.remove(key);
    }

    //// module-level operations

    /**
     * Returns true if a module with the same identity as {@code module} exists in the TAssist.
     */
    public boolean hasModule(TaModule module) {
        requireNonNull(module);
        return modules.contains(module);
    }

    /**
     * Adds a module to the TAssist.
     * The module must not already exist in the TAssist.
     */
    public void addModule(TaModule module) {
        modules.add(module);
    }

    /**
     * Replaces the given module {@code target} in the list with {@code editedTaModule}.
     * {@code target} must exist in the TAssist.
     * The module identity of {@code editedTaModule} must not be the same as another existing module in the TAssist.
     */
    public void setModule(TaModule target, TaModule editedTaModule) {
        requireNonNull(editedTaModule);

        modules.setModule(target, editedTaModule);
    }

    /**
     * Removes {@code key} from this {@code TAssist}.
     * {@code key} must exist in the TAssist.
     */
    public void removeModule(TaModule key) {
        modules.remove(key);
    }

    //// classGroup-level operations

    /**
     * Returns true if a classGroup with the same identity as {@code classGroup} exists in the TAssist.
     */
    public boolean hasClassGroup(ClassGroup classGroup) {
        requireNonNull(classGroup);
        return classGroups.contains(classGroup);
    }

    /**
     * Adds a classGroup to the TAssist.
     * The classGroup must not already exist in the TAssist.
     */
    public void addClassGroup(ClassGroup classGroup) {
        classGroups.add(classGroup);
    }

    /**
     * Replaces the given classGroup {@code target} in the list with {@code editedClassGroup}.
     * {@code target} must exist in the TAssist.
     * The classGroup identity of {@code editedClassGroup} must not be the same as another
     * existing classGroup in the TAssist.
     */
    public void setClassGroup(ClassGroup target, ClassGroup editedClassGroup) {
        requireNonNull(editedClassGroup);

        classGroups.setClassGroup(target, editedClassGroup);
    }

    /**
     * Removes {@code key} from this {@code TAssist}.
     * {@code key} must exist in the TAssist.
     */
    public void removeClassGroup(ClassGroup key) {
        classGroups.remove(key);
    }

    //// util methods

    @Override
    public String toString() {
        return students.asUnmodifiableObservableList().size() + " students"
                + modules.asUnmodifiableObservableList().size() + " modules"
                + classGroups.asUnmodifiableObservableList().size() + " class groups";
        // TODO: refine later
    }

    @Override
    public ObservableList<Student> getStudentList() {
        return students.asUnmodifiableObservableList();
    }


    @Override
    public ObservableList<TaModule> getModuleList() {
        return modules.asUnmodifiableObservableList();
    }

    @Override
    public ObservableList<ClassGroup> getClassGroupList() {
        return classGroups.asUnmodifiableObservableList();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof TAssist // instanceof handles nulls
                && students.equals(((TAssist) other).students)
                && modules.equals(((TAssist) other).modules)
                && classGroups.equals(((TAssist) other).classGroups));
    }

    @Override
    public int hashCode() {
        return Objects.hash(students, modules, classGroups);
    }
}