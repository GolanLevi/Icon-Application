<div align="center">

# 🏋️ Icon Fitness - אפליקציית מכוני כושר

אפליקציית Android לרשת **אייקון פיטנס** שמאפשרת לגלוש בין 35+ סניפים, לראות תפוסה בזמן אמת, לנהל מועדפים ולמצוא מכונים על מפה אינטראקטיבית.

בנויה עם Firebase Authentication, Google Maps, אנימציות Lottie, טעינת תמונות עם Glide ו-Material Design.

פרויקט קורס **פיתוח Android** - מכללת אפקה להנדסה

[🇬🇧 Read in English](README.md)

</div>

---

<div dir="rtl">

## 📱 סרטון הדגמה

</div>

https://github.com/user-attachments/assets/icon_app.mp4

> אם הסרטון לא מתנגן, הקובץ `icon_app.mp4` נמצא בתיקיית הפרויקט.

---

<div dir="rtl">

## 📌 על הפרויקט

בניתי את האפליקציה הזו כפרויקט סופי בקורס פיתוח Android. הרעיון הוא אפליקציה למכוני כושר של רשת אייקון פיטנס - המשתמש נכנס, גולש בין כל הסניפים ברחבי הארץ, מחפש לפי שם, שומר מועדפים, רואה כל מכון על מפה, ובודק את רמת העומס (כמה אנשים מתאמנים עכשיו).

הפרויקט נתן לי ניסיון מעשי עם נושאים מרכזיים באנדרואיד: עבודה עם APIs חיצוניים (Firebase, Google Maps), בניית ממשק משתמש רספונסיבי עם RecyclerView ו-Material Design, ניהול מידע בין מסכים, וטיפול בהרשאות.

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
