# SplitWise LLD


## Requirements -

1. Users can register and update their profiles
2. A user's profile should contain at least their name, phone number and password
3. Users can participate in expenses with other users
4. Users can participate in groups.
5. To add an expense, a user must specify either the group, or 
   the other users involved in the expense, along with who paid what and who owes what. 
   They must also specify a description for the expense.
6. A user can see their total owed amount
7. A user can see a history of the expenses they're involved in.
8. A user can see a history of the expenses made in a group that they're participating in.
9. Users shouldn't be able to query about groups they are not a member of.
10. Only the user who has created a group can add/remove members to the group.
11. Users can request a settle-up. The application should show a list of transactions, 
    which when executed will ensure that the user no longer owes or receives money from any other user. 
    Note that this need not settle-up any other users. 
12. Users can request a settle-up for any group they're participating in. 
    The application should show a list of transactions, 
    which if executed, will ensure that everyone participating in the group is settled up (owes a net of 0 Rs). 
    Note that will only deal with the expenses made inside that group. Expenses outside the group need not be settled. 
    Good to Have Requirements 
13. When settling a group, we should try to minimize the number of transactions that the group members should make to settle up.


## Classes/Entities -

1. User
   - name: String
   - email: String
   - password: String

2. Group
   - descriptions: String
   - createdBy: User
   - members: List<User>
   - expenses: List<Expense>

3. Expense
   - description: String
   - totalAmount: Double
   - expenseBreakup: List<ExpenseBreakup>

4. ExpenseBreakup
   - amount: Double
   - user: User
   - type: ENUM(HAD_PAID, HAD_TO_PAY)


## Schema (Relationship among classes) -

1. User-Group
   - user can be any number of Group
   - A group can have many users
   - Many to Many

2. User-Group (admin)
   - User can create multiple groups
   - Group can be created by only one User.
   - One to Many

3. Group-Expense
   - a group can have many expenses.
   - an expense can belong to only one group (at-max).
   - One to Many

4. Expense to ExpenseBreakup
   - a expense can have many individual expenses
   - an individual expense can only be in one expense (at-max)
   - One to Many.

5. User to ExpenseBreakup
   - User can have many expense transactions
   - expense transaction can have only one user
   - One to Many


## Flow

1. create 3 users.
2. create 1 group.
3. add 2 expenses to group.
4. add direct expense between 2 users.
5. call settle up for individual user on non-group
6. call settle up for individual user in group.
