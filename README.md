# Lab-Assignment-5
You are required to present a department report that accesses csv files. You must put the data on the domain composition of the objects.

dep.csv contains the following

deptCode, deptName, location IT, Information Tech, 2nd floor HR, Human Resource, 3rd floor FNC, Finance, 4th floor

The deptemp.csv is referenced to get the salary of the employees per department:

deptCode, empNo, salary IT, E123, 30000 IT, E124, 45000 IT, E125, 51000 HR, E251, 66000 HR, E252, 25000 FNC, E370, 42000 FNC, E371, 29000 FNC, E372, 37000

To get the details of the employee you must access the emp.csv:

empNo, lastName, firstName, job E123, Maxwell, John, Developer E124, Delos Reyes, Ernesto, Analyst E125, Ortiz, Manuel, Tester E251, Natividad, Lisa, HR Manager E252, Rosanto, Margareth, HR Specialist E370, Baldo, Jason, Team Leader E371, Hernandez, Timothy, Junior Accountant E372, Cruz, Ricardo, CPA

You need to create objects that will handle the retrieval of the csv files to convert it into objects. These are EmployeeDA and EmployeeDA objects. This will be the execution of the sequence:

INSTRUCTIONS: You are not allowed to alter the composition of the domain objects. Stick to the design. Disregard the data in the csv if it is not necessary to the object. Adhere to correct naming conventions in naming variables and objects. Use hashmap as your solution to the problem. Use the department.setDepTotalSalary() in putting the aggregated value into the object. Do not just use the salary accumulation approach in the printing process to get the depTotalSalary.
