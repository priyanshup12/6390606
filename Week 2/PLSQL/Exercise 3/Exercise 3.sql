--Scenario 1: 
create or replace procedure processmonthlyinterest is
   bal accounts.balance%type;
begin
   for acc in (
      select accountid,
             balance
        from accounts
   ) loop
      bal := acc.balance;
      update accounts
         set
         balance = bal * 1.01
       where accountid = acc.accountid;

      dbms_output.put_line('ACCOUNT ID: '
                           || acc.accountid
                           || ', OLD BALANCE: '
                           || bal
                           || ', NEW BALANCE: '
                           ||(bal * 1.01));
   end loop;
   commit;
end;
/

EXEC PROCESSMONTHLYINTEREST;

--Scenario 2:
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
   bonusPercentage IN NUMBER,
   deptName IN VARCHAR2  
) IS
   bonus employees.salary%TYPE;
   sal   employees.salary%TYPE;
BEGIN
   FOR emp IN (
      SELECT employeeid, salary
      FROM employees
      WHERE department = deptName  
   ) LOOP
      sal := emp.salary;
      bonus := sal * (100 + bonusPercentage) / 100;
 
      UPDATE employees
      SET salary = bonus
      WHERE employeeid = emp.employeeid;
 
      DBMS_OUTPUT.PUT_LINE('Employee ID: ' || emp.employeeid ||
                           ', Old salary: ' || sal ||
                           ', New salary: ' || bonus);
   END LOOP;
 
   COMMIT;
END;
/ 


EXEC UPDATEEMPLOYEEBONUS(5, 'HR');

--Scenario 3: 
create or replace procedure transferfunds (
   sender   in accounts.accountid%type,
   receiver in accounts.accountid%type,
   amount   in number
) is
   sender_balance   accounts.balance%type;
   receiver_balance accounts.balance%type;
begin
   select balance
     into sender_balance
     from accounts
    where accountid = sender;

   select balance
     into receiver_balance
     from accounts
    where accountid = receiver;

   if sender_balance < amount then
      dbms_output.put_line('insufficient balance.');
   elsif amount <= 0 then
      dbms_output.put_line('amount cannot be zero or less.');
   else
      update accounts
         set
         balance = balance - amount
       where accountid = sender;

      update accounts
         set
         balance = balance + amount
       where accountid = receiver;

      commit;
      dbms_output.put_line('tranfer successful.');
   end if;

end;