var typed = new Typed(".text", {
    strings: ["Feed your mood","not just your stomach!"],
    typeSpeed: 100,
    backSpeed: 100,
    backDelay: 1000,
    loop:true
});

function openForm(type) {
  document.getElementById("signupForm").style.display = "none";
  document.getElementById("loginForm").style.display = "none";
  if (type === "signup") {
    document.getElementById("signupForm").style.display = "block";
  } else if (type === "login") {
    document.getElementById("loginForm").style.display = "block";
  }
}

function closeForm() {
  document.getElementById("signupForm").style.display = "none";
  document.getElementById("loginForm").style.display = "none";
}

const cursor = document.createElement("div");
cursor.classList.add("animated-cursor");
document.body.appendChild(cursor);

document.addEventListener("mousemove", e => {
  cursor.style.top = `${e.clientY}px`;
  cursor.style.left = `${e.clientX}px`;
});
