--Scenario 1: Discount for Customers Over 60
BEGIN
  FOR cust IN (SELECT customer_id, interest_rate FROM customers WHERE age > 60) LOOP
    UPDATE customers
    SET interest_rate = interest_rate - 1
    WHERE customer_id = cust.customer_id;
  END LOOP;
  COMMIT;
END;

--Scenario 2: Promote Customers to VIP
DECLARE
  v_due_date loans.due_date%TYPE;
  v_customer_id loans.customer_id%TYPE;
BEGIN
  FOR loan_rec IN (
    SELECT customer_id, due_date
    FROM loans
    WHERE due_date <= SYSDATE + 30
  ) LOOP
    DBMS_OUTPUT.PUT_LINE('Reminder: Loan for Customer ID ' || loan_rec.customer_id || ' is due on ' || loan_rec.due_date);
  END LOOP;
END;


--Scenario 3: Loan Reminders for Upcoming Dues
DECLARE
  v_due_date loans.due_date%TYPE;
  v_customer_id loans.customer_id%TYPE;
BEGIN
  FOR loan_rec IN (
    SELECT customer_id, due_date
    FROM loans
    WHERE due_date <= SYSDATE + 30
  ) LOOP
    DBMS_OUTPUT.PUT_LINE('Reminder: Loan for Customer ID ' || loan_rec.customer_id || ' is due on ' || loan_rec.due_date);
  END LOOP;
END;
