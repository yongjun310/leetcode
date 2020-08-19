package com.lc.source.s600

/*
 *	690. Employee Importance
Easy

682

675

Add to List

Share
You are given a data structure of employee information, which includes the employee's unique id, their importance value and their direct subordinates' id.

For example, employee 1 is the leader of employee 2, and employee 2 is the leader of employee 3. They have importance value 15, 10 and 5, respectively. Then employee 1 has a data structure like [1, 15, [2]], and employee 2 has [2, 10, [3]], and employee 3 has [3, 5, []]. Note that although employee 3 is also a subordinate of employee 1, the relationship is not direct.

Now given the employee information of a company, and an employee id, you need to return the total importance value of this employee and all their subordinates.

Example 1:

Input: [[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1
Output: 11
Explanation:
Employee 1 has importance value 5, and he has two direct subordinates: employee 2 and employee 3. They both have importance value 3. So the total importance value of employee 1 is 5 + 3 + 3 = 11.


Note:

One employee has at most one direct leader and may have several subordinates.
The maximum number of employees won't exceed 2000.
 */

class S690 {
    class Employee {
        var id:Int = 0
        var importance:Int = 0
        var subordinates:List<Int> = listOf()
    }

    fun getImportance(employees: List<Employee?>, id: Int): Int {
        var employee = Employee()
        var sum = 0
        for(em in employees) {
            if(em != null && em.id == id) {
                employee = em
                sum = em.importance
                break
            }
        }
        var subordinates = employee.subordinates
        var list = employees.toMutableList()
        while(subordinates.isNotEmpty()) {
            val iterator = list.iterator()
            while (iterator.hasNext()) {
                var next = iterator.next()
                if (next != null && subordinates.contains(next.id)) {
                    sum += next.importance
                    subordinates -= next.id
                    subordinates += next.subordinates
                    iterator.remove()
                }
            }
        }
        return sum
    }
}