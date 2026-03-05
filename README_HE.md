<div align="center">

# 🏋️ Icon Fitness - אפליקציית מכוני כושר

אפליקציית Android לרשת **אייקון פיטנס** שמאפשרת לגלוש בין 35+ סניפים, לראות תפוסה בזמן אמת, לנהל מועדפים ולמצוא מכונים על מפה אינטראקטיבית.

בנויה עם Firebase Authentication, Google Maps, אנימציות Lottie, טעינת תמונות עם Glide ו-Material Design.

פרויקט קורס **פיתוח Android** - מכללת אפקה להנדסה

[🇬🇧 Read in English](README.md)

</div>

---

<div dir="rtl">

## 📱 הצצה לאפליקציה

<p align="center">
  <strong>צפייה ברשימת הסניפים, נתוני התפוסה בזמן אמת ואפשרויות החיוג והמועדפים:</strong><br><br>
  <img src="icon_photo1.jpeg" width="70%" />
</p>

<p align="center">
  <strong>התמצאות מהירה במפה, איתור סניפים קרובים ובדיקת זמינות:</strong><br><br>
  <img src="icon_photo2.jpeg" width="70%" />
</p>

### סרטון הדגמה מלא

[🎬 צפה בסרטון ההדגמה של האפליקציה (לחץ כאן)](icon_app.mp4)

> הפעלת הסרטון תפתח את נגן הווידאו המובנה של GitHub או תוריד את הקובץ.

---

<div dir="rtl">

## 📌 על הפרויקט והבעיה שהוא פותר

בניתי את האפליקציה הזו כפרויקט סופי בקורס פיתוח Android מתוך צורך אמיתי - לפתור את בעיית העומס במכוני הכושר בישראל. כולנו מכירים את התסכול של להגיע למכון ולגלות שאין אפילו הליכון אחד פנוי, או שצריך לחכות חצי שעה למשקולות. 

האפליקציה הזו באה לתת פתרון נגיש וחכם: דרך האפליקציה, כל משתמש (שנכנס דרך מערכת הזדהות של Firebase) יכול לראות את כמות המתאמנים בזמן אמת בכל אחד מ-35+ הסניפים של רשת אייקון פיטנס ברחבי הארץ. ככה אפשר לתכנן את האימון בקלות, לדעת מראש לאיזה סניף כדאי ללכת מתי, ולחסוך זמן יקר.

בנוסף לפתרון בעיית העומס, האפליקציה מאפשרת לחפש סניפים, לשמור מועדפים לגישה מהירה, למצוא כל מכון על מפה אינטראקטיבית, והכל בממשק נוח ומהיר. הפרויקט נתן לי ניסיון מעשי עם נושאים במערכות מורכבות: עבודה מול APIs חיצוניים (Google Maps, Firebase), ניהול מידע בצורה שיתופית בין מסכים, יצירת ממשק משתמש רספונסיבי ודינמי (Material Design), וטיפול מתקדם בהרשאות מערכת.

### זרימת האפליקציה:

```
מסך Splash עם אנימציה → התחברות Firebase (אימייל / טלפון / Google) → אפליקציה ראשית (3 טאבים)
```

</div>

---

<div dir="rtl">

## 🧩 פיצ'רים

</div>

| פיצ'ר | תיאור |
|-------|--------|
| **מסך פתיחה** | אנימציית Lottie - רצה פעם אחת בעליית האפליקציה |
| **התחברות Firebase** | כניסה באימייל, טלפון, או חשבון Google דרך Firebase Auth UI |
| **רשימת מכונים (Home)** | RecyclerView עם 35+ סניפים - פוסטר, שם, כתובת, דירוג, טלפון |
| **חיפוש** | סינון בזמן אמת - מקלידים ומיד רואים תוצאות |
| **מועדפים** | לחיצה על הלב שומרת מכון למועדפים (SharedPreferences + Gson) |
| **Google Maps** | מפה אינטראקטיבית עם markers מותאמים לכל סניף |
| **תפוסה חיה** | כמות המתאמנים מתעדכנת כל 10 שניות, עם סמן רמת עומס |
| **חיוג לסניף** | לחיצה על אייקון הטלפון פותחת חייגן ישיר |
| **יציאה** | כפתור logout שמחזיר למסך ההתחברות |

---

<div dir="rtl">

## 🛠️ טכנולוגיות וספריות

</div>

| טכנולוגיה | שימוש |
|-----------|-------|
| **Java** | שפת הפיתוח הראשית |
| **Firebase Auth** | אימות משתמשים (אימייל, טלפון, Google) |
| **Firebase Auth UI** | מסכי התחברות מוכנים עם עיצוב מותאם |
| **Google Maps SDK** | הצגת מפה עם markers מותאמים ומיקום |
| **Google Location Services** | מיקום נוכחי של המשתמש |
| **Lottie** | אנימציית מסך פתיחה |
| **Glide** | טעינת תמונות מ-URL עם placeholder |
| **Gson** | המרת JSON לאובייקטים ב-SharedPreferences |
| **Material Design** | רכיבי UI (BottomNavigationView, ShapeableImageView, RatingBar) |
| **RecyclerView** | רשימה נגללת יעילה עם ViewHolder pattern |
| **SharedPreferences** | שמירה מקומית של מכונים מועדפים |

---

<div dir="rtl">

## 🏗️ ארכיטקטורה

</div>

```
com.example.iconapplication/
│
├── MainActivity.java               # ניהול ניווט תחתון (Home/Favorites/Map)
├── LoginActivity.java              # Firebase Auth - בדיקת session קיים
├── LottieSplashActivity.java       # מסך splash עם אנימציה → ניווט ל-Login
│
├── Fragments/
│   ├── HomeActivity.java           # רשימת מכונים + חיפוש + logout
│   ├── FavoriteActivity.java       # רשימת מועדפים מ-SharedPreferences
│   └── MapActivity.java           # Google Maps עם markers
│
├── Models/
│   └── GYM.java                   # מודל נתונים עם Builder-style setters
│
├── Interfaces/
│   └── GYMCallback.java           # ממשק callback ללחיצה על מועדפים
│
└── Utilities/
    ├── App.java                   # מחלקת Application - מאתחלת ImageLoader
    ├── DataManager.java           # מקור נתונים (35+ סניפים) + CRUD מועדפים + עדכון חי
    ├── GYMAdapter.java            # RecyclerView adapter עם click handlers
    └── ImageLoader.java           # Singleton wrapper ל-Glide
```

<div dir="rtl">

### החלטות עיצוב עיקריות:
- **DataManager** משתמש ב-Singleton pattern - הנתונים נטענים פעם אחת ומשותפים בין כל ה-Fragments
- **ImageLoader** עוטף את Glide ב-Singleton כדי לא להעביר Context בכל מקום
- **GYM model** משתמש ב-Builder-style setters (מחזיר `this`) ליצירת אובייקטים בצורה נקייה
- **מועדפים** נשמרים מקומית ב-SharedPreferences + Gson, לא בשרת
- **תפוסה חיה** מדמה נתונים בזמן אמת עם `Handler` שמתעדכן כל 10 שניות

</div>

---

<div dir="rtl">

## 🚀 הרצה

1. שכפלו את ה-repo
2. פתחו ב-**Android Studio** (Hedgehog ומעלה מומלץ)
3. הוסיפו `google-services.json` משלכם מ-[Firebase Console](https://console.firebase.google.com/)
4. הוסיפו מפתח Google Maps API ב-`AndroidManifest.xml`
5. סנכרנו Gradle והריצו על מכשיר/אמולטור (API 26+)

> **הערה:** הקובץ `google-services.json` לא עולה ל-repo מסיבות אבטחה. תצטרכו ליצור פרויקט Firebase משלכם ולהפעיל Authentication (Email, Phone, Google).

</div>

---

<div dir="rtl">

## 👤 מפתח

**גולן לוי** - מכללת אפקה להנדסה

## 📄 רישיון

הפרויקט תחת רישיון MIT.

</div>
