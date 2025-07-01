var typed = new Typed(".text", {
  strings: ["Feed your mood", "not just your stomach!"],
  typeSpeed: 100,
  backSpeed: 100,
  backDelay: 1000,
  loop: true
});

function openForm(type) {
  document.getElementById("signupForm").style.display = "none";
  document.getElementById("loginForm").style.display = "none";
  document.getElementById("signup-error").innerText = "";
  document.getElementById("login-error").innerText = "";
  if (type === "signup") {
    document.getElementById("signupForm").style.display = "block";
  } else if (type === "login") {
    document.getElementById("loginForm").style.display = "block";
  }
}

function closeForm() {
  document.getElementById("signupForm").style.display = "none";
  document.getElementById("loginForm").style.display = "none";
  document.getElementById("signup-error").innerText = "";
  document.getElementById("login-error").innerText = "";
}

const cursor = document.createElement("div");
cursor.classList.add("animated-cursor");
document.body.appendChild(cursor);

window.addEventListener("scroll", function () {
  const header = document.querySelector(".header");
  if (window.scrollY > 50) {
    header.classList.add("scrolled");
  } else {
    header.classList.remove("scrolled");
  }
});

document.addEventListener("mousemove", e => {
  cursor.style.top = `${e.clientY}px`;
  cursor.style.left = `${e.clientX}px`;
});


const signupForm = document.getElementById("signupForm");
signupForm.insertAdjacentHTML("beforeend", '<p id="signup-error" style="color: red; font-weight: bold;"></p>');
signupForm.addEventListener("submit", async function (e) {
  e.preventDefault();

  const username = signupForm.querySelector("#username").value;
  const email = signupForm.querySelector("#email").value;
  const password = signupForm.querySelector("#password").value;
  const errorMessage = document.getElementById("signup-error");

  const response = await fetch("http://localhost:8081/api/auth/register", {
    method: "POST",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify({
      username: username,
      email: email,
      password: password
    })
  });

  const resultText = await response.text();
  errorMessage.innerText = resultText;

  if (resultText.includes("successful")) {
    signupForm.reset();
    closeForm();
  }
});


const loginForm = document.getElementById("loginForm");
loginForm.insertAdjacentHTML("beforeend", '<p id="login-error" style="color: red; font-weight: bold;"></p>');
loginForm.addEventListener("submit", async function (e) {
  e.preventDefault();

  const email = loginForm.querySelector("#email").value;
  const password = loginForm.querySelector("#password").value;
  const errorMessage = document.getElementById("login-error");

  const response = await fetch("http://localhost:8081/api/auth/login", {
    method: "POST",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify({
      email: email,
      password: password
    })
  });

  const resultText = await response.text();
  errorMessage.innerText = resultText;

  if (resultText.includes("successful")) {
    localStorage.setItem("userEmail", email);
    loginForm.reset();
    closeForm();
    window.location.href = "dashboard.html"; 
  }
});


function showWelcomeMessage(email) {
  const header = document.querySelector(".header");
  const existing = document.getElementById("welcome-msg");
  if (existing) return; 
  const welcome = document.createElement("p");
  welcome.id = "welcome-msg";
  welcome.innerText = `Welcome, ${email}!`;
  welcome.style.color = "#444";
  welcome.style.marginTop = "10px";
  welcome.style.fontSize = "1rem";
  welcome.style.textAlign = "center";

 
  const logoutBtn = document.createElement("button");
  logoutBtn.innerText = "Logout";
  logoutBtn.style.marginLeft = "10px";
  logoutBtn.style.padding = "5px 10px";
  logoutBtn.style.border = "none";
  logoutBtn.style.borderRadius = "8px";
  logoutBtn.style.cursor = "pointer";
  logoutBtn.style.backgroundColor = "#ff6600";
  logoutBtn.style.color = "white";
  logoutBtn.onclick = () => {
    localStorage.removeItem("userEmail");
    window.location.href = "index.html";
  };

  welcome.appendChild(logoutBtn);
  header.appendChild(welcome);
}
const hoverables = document.querySelectorAll("button, a, input, .signup-btn, .login-btn");

hoverables.forEach(el => {
  el.addEventListener("mouseenter", () => {
    cursor.classList.add("hovered");
    console.log("Hovered:", el);  
  });
  el.addEventListener("mouseleave", () => {
    cursor.classList.remove("hovered");
    console.log("Unhovered:", el);  
  });
});

function scrollToExplore() {
  window.scrollTo({
    top: window.innerHeight,
    behavior: "smooth"
  });
}

window.addEventListener("load", () => {
  const savedEmail = localStorage.getItem("userEmail");
  if (savedEmail) {
    showWelcomeMessage(savedEmail);
  }
});
