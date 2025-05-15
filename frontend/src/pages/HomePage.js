import React, { useState } from "react";
import landingBG from "../images/landingBG.png";
import "../css/home.css";
import one from "../images/1.png";
import two from "../images/2.png";
import three from "../images/3.png";
import four from "../images/4.png";

import g1 from "../images/grid1.png";
import g2 from "../images/grid2.png";
import g3 from "../images/grid3.png";
import g4 from "../images/grid4.png";
import g5 from "../images/grid5.png";
import g6 from "../images/grid6.png";
import why from "../images/whyus.png";
import Navbar from "../components/Navbar";
const Home = () => {
  const [openFAQ, setOpenFAQ] = useState(null);

  const toggleFAQ = (index) => {
    setOpenFAQ(openFAQ === index ? null : index);
  };

  const faqData = [
    {
      question: "What services do you offer?",
      answer:
        "We offer a variety of legal services including immigration assistance, matrimonial issues, property disputes, and personal legal matters.",
    },
    {
      question: "How can I contact you?",
      answer:
        "You can contact us through our website contact form, or by calling our office at (123) 456-7890.",
    },
    {
      question: "Do you offer free consultations?",
      answer:
        "Yes, we offer a free initial consultation to discuss your legal needs and how we can assist you.",
    },
  ];
  return (
    <div className="homecontainer">
      <div className="home-container">
        <div className="banner">
          <h1 className="heading">Legal Aid Center</h1>
          <h3>Your Rights, Our Mission</h3>
          <h1 className="heading3">Where Legal Aid Meets Compassion </h1>
        </div>
        <div className="firstsection">
          <div className="info">
            <h1 className="section-heading">Trust your future &</h1>
            <p className="section-subheading">Peaceful Life</p>
            <p className="description">
              Expert legal support for a secure and stress-free future.
              Compassionate guidance to protect your rights and achieve the best
              outcomes. Your partner in navigating life's legal challenges with
              confidence and peace of mind.
            </p>
          </div>
          <div className="character">
            <div className="firstcolumn">
              <div className="firstblock">
                <img src={one} alt="BG" />
                <h3>Immigration</h3>
                <p>
                  Guidance and support for all your immigration needs, from
                  visas to citizenship, ensuring a smooth and successful
                  process.
                </p>
              </div>
              <div className="secondblock">
                <img src={two} alt="BG" />
                <h3>Matrimonial</h3>
                <p>
                  Guidance and support for all your immigration needs, from
                  visas to citizenship, ensuring a smooth and successful
                  process.
                </p>
              </div>
            </div>
            <div className="secondcolumn">
              <div className="thirdblock">
                <img src={three} alt="BG" />
                <h3>Property</h3>
                <p>
                  Guidance and support for all your immigration needs, from
                  visas to citizenship, ensuring a smooth and successful
                  process.
                </p>
              </div>
              <div className="fourthblock">
                <img src={four} alt="BG" />
                <h3>Personal</h3>
                <p>
                  Guidance and support for all your immigration needs, from
                  visas to citizenship.
                </p>
              </div>
            </div>
          </div>
        </div>
        <hr className="line"></hr>
        <div className="solution">
          <h2 className="mainheader">Experience a smarter</h2>
          <p className="subheader">Legal solution platform in your hand</p>
          <div className="gridcontainer">
            <div className="griditems">
              <img src={g1} alt="BG" />
              <h3 className="gridheading">Immigration Assistance</h3>
              <p className="griddescription">
                Support for visas, residency, and citizenship, guiding you every
                step of the way.
              </p>
            </div>
            <div className="griditems">
              <img src={g2} alt="BG" />
              <h3 className="gridheading">Immigration Assistance</h3>
              <p className="griddescription">
                Protect your trademarks, copyrights, and patents with expert
                legal services.
              </p>
            </div>
            <div className="griditems">
              <img src={g3} alt="BG" />
              <h3 className="gridheading">Immigration Assistance</h3>
              <p className="griddescription">
                Expert advice to ensure your business meets all legal
                regulations.
              </p>
            </div>
            <div className="griditems">
              <img src={g4} alt="BG" />
              <h3 className="gridheading">Immigration Assistance</h3>
              <p className="griddescription">
                Professional will drafting to ensure your wishes are honored.
              </p>
            </div>
            <div className="griditems">
              <img src={g5} alt="BG" />
              <h3 className="gridheading">Immigration Assistance</h3>
              <p className="griddescription">
                Thorough preparation of contracts and legal documents.
              </p>
            </div>
            <div className="griditems">
              <img src={g6} alt="BG" />
              <h3 className="gridheading">Immigration Assistance</h3>
              <p className="griddescription">
                Manage and protect your assets for the future.
              </p>
            </div>
          </div>
        </div>
        <hr className="line"></hr>
        <div className="why">
          <h2 className="whyheader">Why Choose</h2>
          <p className="us">Us?</p>

          <div className="sides-container">
            <div className="leftside">
              <div className="leftitems">
                <h3>Economics</h3>
                <p>Affordable legal solutions tailored to your needs.</p>
              </div>
              <div className="leftitems">
                <h3>Professional</h3>
                <p> Expert legal advice from experienced professionals.</p>
              </div>
              <div className="leftitems">
                <h3>Security</h3>
                <p>Ensuring your legal matters are securely handled.</p>
              </div>
            </div>
            <img src={why} className="whyimg" alt="BG" />

            <div className="rightside">
              <div className="rightitems">
                <h3>Economics</h3>
                <p>Affordable legal solutions tailored to your needs.</p>
              </div>
              <div className="rightitems">
                <h3>Professional</h3>
                <p> Expert legal advice from experienced professionals.</p>
              </div>
              <div className="rightitems">
                <h3>Security</h3>
                <p>Ensuring your legal matters are securely handled.</p>
              </div>
            </div>
          </div>
        </div>
        <br />
        <br />
        <hr className="line"></hr>
        <div className="needhelp">
          <h2 className="need">Need Help?</h2>
          <p className="common">Common Questions</p>
          <div className="faq-section">
            {faqData.map((item, index) => (
              <div key={index} className="faq-item">
                <button
                  className="faq-question"
                  onClick={() => toggleFAQ(index)}
                >
                  {item.question}
                </button>
                <div
                  className={`faq-answer ${openFAQ === index ? "show" : ""}`}
                >
                  {item.answer}
                </div>
              </div>
            ))}
          </div>
        </div>{" "}
        <br /> <br />
        <footer>
          <div className="footer">
            <div className="footersection">
              <div className="firstfootersection">
                <div className="getintouch">
                  <h2>GET IN TOUCH</h2>
                  <p>
                    We're here to help with any legal inquiries or concerns you
                    may have. Feel free to reach out to us through the following
                    methods:
                  </p>
                  <span>
                    <i className="fas fa-phone-alt"></i> +975-177777777
                  </span>
                  <br /> <br />
                  <span>
                    <i className="fas fa-envelope"></i> LAC@gmail.com
                  </span>
                  <br /> <br />
                  <span>
                    <i className="fas fa-map-marker-alt"></i>Thimphu
                  </span>
                </div>
              </div>
              <div className="firstfootersection">
                <div className="logos">
                  <p>Follow us on</p>
                  <p>
                    <a href="https://www.facebook.com">
                      <i className="fab fa-facebook"></i>
                    </a>
                    <a href="https://www.whatsapp.com">
                      <i className="fab fa-whatsapp"></i>
                    </a>
                    <a href="https://telegram.org">
                      <i className="fab fa-telegram"></i>
                    </a>
                    <a href="https://www.twitter.com">
                      <i className="fab fa-twitter"></i>
                    </a>
                    <a href="https://www.linkedin.com">
                      <i className="fab fa-linkedin"></i>
                    </a>
                  </p>
                  <p>© 2019-2024 Copyright | All Rights Reserved.</p>
                </div>
              </div>

              <div className="firstfootersection">
                <div class="form-container">
                  <h1>Say Something,</h1>
                  <form action="/submit" method="post">
                    <label for="name">Name</label>
                    <input
                      className="feedbackinput"
                      type="text"
                      id="name"
                      name="name"
                      required
                    ></input>

                    <label for="email">Email</label>
                    <input
                      className="feedbackinput"
                      type="email"
                      id="email"
                      name="email"
                      required
                    ></input>

                    <label for="message">Message</label>
                    <textarea
                      id="message"
                      name="message"
                      rows="5"
                      required
                    ></textarea>

                    <button className="feedbackbutton" type="submit">
                      Submit
                    </button>
                  </form>
                </div>
              </div>
            </div>
          </div>
        </footer>
      </div>
    </div>
  );
};

export default Home;
