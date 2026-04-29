# BMI Calculator Application

A Java-based BMI calculator with user authentication and unit conversion support.

## Features
- Login with existing accounts or continue as Guest
- Calculates BMI using metric units (kg, cm) and view results in Metric or Imperial units
- Classifies results as Underweight, Normal, Overweight, or Obese (Class I-III)

## Default Accounts
Username + Password   
- alice, pass123
- bob, qwerty
- charlie, hello99
- diana, sunshine
- eve, qwerty123

## Project Structure
- App.java (Main application entry point)
- util folder:
    - BMICalculator.java (BMI calculation and display logic)
    - Input.java (User input handling with validation)
    - LoginHandle.java (Authentication and menu flow)
    - UserDatabase.java (User credentials storage)
- README.md

## BMI Categories
- < 18.5 = Underweight
- 18.5 - 24.9 = Normal weight
- 25.0 - 29.9 = Overweight
- 30.0 - 34.9 = Obese Class I
- 35.0 - 39.9 = Obese Class II
- ≥ 40.0 = Obese Class III
