import React from "react";
import loginbg from "../images/loginbg.png";
import { Link } from "react-router-dom";

// import cornerImg from "../img/corner.png"; // Assuming you have an image for the corners
import "../css/signin.css";
import b1 from "../images/border1.png";
import b2 from "../images/border2.png";
import b3 from "../images/border3.png";
import b4 from "../images/border4.png";
import Navbar from "../components/Navbar";
const Login = () => {
  const handleSubmit = (event) => {
    event.preventDefault(); // Prevents the default form submit behavior

    // Get the input values
    const email = event.target.email.value;
    const password = event.target.password.value;

    // Handle form submission logic here (e.g., send data to API)
    console.log("Email:", email);
    console.log("Password:", password);

    // Example of redirecting or updating state can be added here
    // e.g., redirect to another page or update the app state
  };
  return (
    <div className="loginpage">
      <Navbar navItems={[["Home", "/"]]} isLoggedIn={false} />

      <div className="signin">
        <div className="form">
          <img src={b1} alt="corner" className="corner top-left" />
          <img src={b2} alt="corner" className="corner top-right" />

          <h2>Sign In to Legal Aid Center</h2>
          <br></br>
          <form onSubmit={handleSubmit}>
            <div className="input-group">
              <label>Email</label>
              <input type="text" id="email" name="email" required />
            </div>
            <div className="input-group">
              <label>Password</label>
              <input type="password" id="password" name="password" required />
            </div>
            <button type="submit" className="login-btn">
              Login
            </button>
          </form>

          <div className="form-footer">
            <a href="/forgot-password" className="forgot-password-link">
              Forgot password?
            </a>
            <div className="signup-link">
              <p>Not a member? </p>
              <Link to="/signup">
                <button className="signup-btn">Sign up</button>
              </Link>
            </div>
          </div>
          <img src={b4} alt="corner" className="corner bottom-left" />
          <img src={b3} alt="corner" className="corner bottom-right" />
        </div>
      </div>
    </div>
  );
};

export default Login;
