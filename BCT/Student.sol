// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;

contract StudentData {
    // Structure to store student data
    struct Student {
        uint id;
        string name;
        uint age;
        string course;
    }

    // Array to hold list of students
    Student[] public students;

    // Mapping to check if student ID already exists
    mapping(uint => bool) public studentExists;

    // Event to notify when a student is added
    event StudentAdded(uint id, string name, uint age, string course);

    // Function to add a new student
    function addStudent(uint _id, string memory _name, uint _age, string memory _course) public {
        require(!studentExists[_id], "Student ID already exists");

        // Create a new student and add it to the array
        students.push(Student(_id, _name, _age, _course));
        studentExists[_id] = true;

        // Emit event
        emit StudentAdded(_id, _name, _age, _course);
    }

    // Function to get the total number of students
    function getTotalStudents() public view returns (uint) {
        return students.length;
    }

    // Function to get details of a student by index
    function getStudent(uint index) public view returns (uint, string memory, uint, string memory) {
        require(index < students.length, "Invalid index");
        Student storage student = students[index];
        return (student.id, student.name, student.age, student.course);
    }

    // Fallback function to handle unexpected calls
    fallback() external payable {
        revert("Function not found");
    }

    // Receive function to handle direct ether transfers
    receive() external payable {
        // Ether received, but no action needed
    }
}