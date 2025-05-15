import React, { useState } from "react";
import { Link } from "react-router-dom";
import "../css/signup.css";
import b1 from "../images/border1.png";
import b2 from "../images/border2.png";
import b3 from "../images/border3.png";
import b4 from "../images/border4.png";
import Navbar from "../components/Navbar";
const SignUp = () => {
  const [userType, setUserType] = useState("Client");

  // Function to handle toggle
  const handleToggle = (type) => {
    setUserType(type);
  };

  return (
    <div className="createnewaccount">
      <Navbar navItems={[["Home", "/"]]} isLoggedIn={false} />

      <div className="signup">
        <div className="signup-container">
          {/* <div className="corner">
          <img src={b1} alt="corner" className="corner top-left" />
          <img src={b2} alt="corner" className="corner top-right" />
          <img src={b4} alt="corner" className="corner bottom-left" />
          <img src={b3} alt="corner" className="corner bottom-right" />
        </div> */}
          <h2>Sign Up to Legal Aid Center</h2>

          {/* Toggle Buttons */}
          <div className="toggle-buttons">
            <button
              onClick={() => handleToggle("Client")}
              className={userType === "Client" ? "active" : "inactive"}
            >
              Sign Up as Client
            </button>
            <button
              onClick={() => handleToggle("Lawyer")}
              className={userType === "Lawyer" ? "active" : "inactive"}
            >
              Sign Up as Lawyer
            </button>
          </div>

          {/* Client Form */}
          {userType === "Client" && (
            <form className="signupform">
              <label>
                Full Name:
                <input type="text" name="fullName" />
              </label>
              <label>
                Gender:
                <select name="gender">
                  <option value="male">Male</option>
                  <option value="female">Female</option>
                  <option value="other">Other</option>
                </select>
              </label>
              <label>
                Contact No:
                <input type="text" name="contact" />
              </label>
              <label>
                Email:
                <input type="email" name="email" />
              </label>
              <label>
                CID:
                <input type="text" name="cid" />
              </label>
              <label>
                Date of Birth:
                <input type="date" name="dob" />
              </label>
              <label>
                Dzongkhag:
                <input type="text" name="dzongkhag" />
              </label>
              <label>
                Password:
                <input type="password" name="password" />
              </label>
              <label>
                Confirm Password:
                <input type="password" name="confirmPassword" />
              </label>
              <button className="signupbutton" type="submit">
                Sign Up as Client
              </button>
            </form>
          )}

          {/* Lawyer Form */}
          {userType === "Lawyer" && (
            <form className="signupform">
              <label>
                Full Name:
                <input type="text" name="fullName" />
              </label>
              <label>
                Gender:
                <select name="gender">
                  <option value="male">Male</option>
                  <option value="female">Female</option>
                  <option value="other">Other</option>
                </select>
              </label>
              <label>
                Contact No:
                <input type="text" name="contact" />
              </label>
              <label>
                Email:
                <input type="email" name="email" />
              </label>
              <label>
                CID:
                <input type="text" name="cid" />
              </label>
              <label>
                Date of Birth:
                <input type="date" name="dob" />
              </label>
              <label>
                Dzongkhag:
                <input type="text" name="dzongkhag" />
              </label>
              <label>
                Specialization:
                <input type="text" name="specialization" />
              </label>
              <label>
                License No:
                <input type="text" name="licenseNo" />
              </label>
              <label>
                Password:
                <input type="password" name="password" />
              </label>
              <label>
                Confirm Password:
                <input type="password" name="confirmPassword" />
              </label>
              <button className="signupbutton" type="submit">
                Sign Up as Lawyer
              </button>
            </form>
          )}
        </div>
      </div>
    </div>
  );
};

export default SignUp;
