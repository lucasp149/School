package classes;

public interface IStudentsManage {

   default int calculateStudentsLeft(int _maxStudents, int _assignedStudents){
       return _maxStudents - _assignedStudents;
   }

   void addStudent (Student _student) throws FullClassroomException;
}
