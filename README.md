# Mood Meal 🍽️🍲

A mood-based meal recommendation app. Tell it how you're feeling — by voice or by letting your camera read your expression — and it suggests a meal to match.

**🔗 Live site:** https://mood-meal-1.onrender.com
**🔗 Backend API:** https://mood-meal-ppvx.onrender.com


## Features

- **Voice-based mood detection** — speak how you're feeling, and the app suggests a meal
- **Camera-based mood detection** — uses [face-api.js](https://github.com/justadudewhohacks/face-api.js) to read facial expressions in real time and suggest a meal to match
- **User accounts** — sign up and log in, with accounts stored in a real Postgres database
- **Feedback system** — rate meal suggestions with a star rating and leave comments
- **Password validation** — enforced complexity rules on signup

## Tech stack

- **Backend:** Java, Spring Boot, deployed on Render
- **Frontend:** HTML, CSS, JavaScript, deployed on Render
- **Database:** PostgreSQL (hosted on [Neon](https://neon.tech))
- **Face detection:** face-api.js (browser-based, no server-side ML)
- **Voice input:** Web Speech API

## How it works

1. Tell it your mood — speak, or let your camera read your expression
2. Your mood is matched to a meal suggestion via the backend
3. Rate the suggestion and leave feedback

## Running locally

1. Clone the repository
   ```
   git clone https://github.com/ABThakur123/Mood-Meal.git
   cd Mood-Meal
   ```
2. **Backend:** navigate to `moodmeal/`, and run it with Maven:
   ```
   cd moodmeal
   ./mvnw spring-boot:run
   ```
   You'll need a PostgreSQL database and to set these environment variables: `SPRING_DATASOURCE_URL`, `SPRING_DATASOURCE_USERNAME`, `SPRING_DATASOURCE_PASSWORD`.
3. **Frontend:** open `moodmealfrontend/index.html` or the root `index.html` directly in a browser. Update the API URLs in `main.js` and `mood.html` if you're not using the deployed backend.

## Known limitations

- Hosted on Render's free tier, so the first request after a period of inactivity may take 30-60 seconds while the server wakes up (a loading indicator is shown during this time)
- No password hashing yet — passwords are currently stored as plain text, which would need to change before any real production use

## Contributors

- [Abhishek Singh](https://github.com/ABThakur123)
- [ShubhanginiJadhav](https://github.com/ShubhanginiJadhav)
