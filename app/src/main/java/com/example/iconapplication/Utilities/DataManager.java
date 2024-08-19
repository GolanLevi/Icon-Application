package com.example.iconapplication.Utilities;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;

import com.example.iconapplication.Models.GYM;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DataManager {
    private static final String PREFS_NAME = "gym_prefs";
    private static final String FAVORITES_KEY = "favorites";
    private static final Random random = new Random();
    private static final Handler handler = new Handler();

    private static ArrayList<GYM> gyms;

    public static ArrayList<GYM> getGyms() {
        if (gyms == null) {
            gyms = new ArrayList<>();

            gyms.add(new GYM()
                .setName("אייקון פיטנס רמלה")
                .setAddress("שדרות דוד רזיאל 1, רמלה")
                .setPhoneNumber("+972 9-777-8870")
                .setRating(4.3f)
                .setPoster("https://media.istockphoto.com/id/1448303096/photo/gym-equipment-and-weights-of-fitness-background-for-exercise-training-or-heavy-workout-for.jpg?s=612x612&w=0&k=20&c=IUnGrKeIoHpDCMhA6MVxxJANZuKcrCIvAw5Mp5sONmo=")
                .setLatitude(31.930750)
                .setLongitude(34.866260)
                .setCurrentExercisers(random.nextInt(70) + 1));

        gyms.add(new GYM()
                .setName("אייקון פיטנס רחובות")
                .setAddress("הר הצופים 74, רחובות, 76620")
                .setPhoneNumber("+972 9-777-8870")
                .setRating(5.0f)
                .setPoster("https://static.vecteezy.com/system/resources/previews/031/597/022/non_2x/the-gym-features-rows-of-dumbbells-offering-a-wide-range-of-weights-vertical-mobile-wallpaper-ai-generated-free-photo.jpg")
                .setLatitude(31.892770)
                .setLongitude(34.811340)
                .setCurrentExercisers(random.nextInt(70) + 1));

        gyms.add(new GYM()
                .setName("אייקון פיטנס ראשון לציון")
                .setAddress("רוטשילד 45, ראשון לציון")
                .setPhoneNumber("+972 9-777-8870")
                .setRating(4.1f)
                .setPoster("https://static.vecteezy.com/system/resources/previews/031/597/067/large_2x/within-the-gyms-walls-a-comprehensive-selection-of-workout-equipment-is-available-vertical-mobile-wallpaper-ai-generated-free-photo.jpg")
                .setLatitude(31.964240)
                .setLongitude(34.804570)
                .setCurrentExercisers(random.nextInt(70) + 1));

        gyms.add(new GYM()
                .setName("Icon Fitness מודיעין")
                .setAddress("דם המכבים 38, מודיעין מכבים רעות, ישראל")
                .setPhoneNumber("+972 9-777-8870")
                .setRating(3.7f)
                .setPoster("https://static.vecteezy.com/system/resources/previews/031/597/017/large_2x/the-gym-features-rows-of-dumbbells-offering-a-wide-range-of-weights-vertical-mobile-wallpaper-ai-generated-free-photo.jpg")
                .setLatitude(31.899920)
                .setLongitude(35.000150)
                .setCurrentExercisers(random.nextInt(70) + 1));

        gyms.add(new GYM()
                .setName("ICON Fitness Holon")
                .setAddress("רחוב המרכבה 38, חולון")
                .setPhoneNumber("+972 9-777-8870")
                .setRating(4.4f)
                .setPoster("https://static.vecteezy.com/system/resources/previews/031/597/060/large_2x/within-the-gyms-walls-a-comprehensive-selection-of-workout-equipment-is-available-vertical-mobile-wallpaper-ai-generated-free-photo.jpg")
                .setLatitude(32.00769861390224)
                .setLongitude(34.80717185767127)
                .setCurrentExercisers(random.nextInt(70) + 1));

        gyms.add(new GYM()
                .setName("אייקון פיטנס יהוד")
                .setAddress("אלטלף 4, יהוד")
                .setPhoneNumber("09-777-8870")
                .setRating(4.0f)
                .setPoster("https://t3.ftcdn.net/jpg/06/30/35/82/360_F_630358206_Y8QujTARHWHihSZKdaIPYKJ1q1FEgIcJ.jpg")
                .setLatitude(32.030000)
                .setLongitude(34.890000)
                .setCurrentExercisers(random.nextInt(70) + 1));

        gyms.add(new GYM()
                .setName("אייקון פיטנס אשקלון ברנע")
                .setAddress("רחבעם זאבי 4, אשקלון")
                .setPhoneNumber("052-333-9940")
                .setRating(4.4f)
                .setPoster("https://static.vecteezy.com/system/resources/previews/031/596/927/non_2x/neatly-organized-rows-of-dumbbells-await-gym-goers-for-diverse-weightlifting-exercises-vertical-mobile-wallpaper-ai-generated-free-photo.jpg")
                .setLatitude(31.677317)
                .setLongitude(34.573561)
                .setCurrentExercisers(random.nextInt(70) + 1));

            gyms.add(new GYM()
                    .setName("אייקון פיטנס - בן יהודה")
                    .setAddress("בן יהודה 77, תל אביב")
                    .setPhoneNumber("+972 9-777-8870")
                    .setRating(4.0f)
                    .setPoster("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTheAwDww2BZXKj9DZAYn3ZgapvVEqYlwcVAg&s")
                    .setLatitude(32.083850)
                    .setLongitude(34.773750)
                    .setCurrentExercisers(random.nextInt(70) + 1));

            gyms.add(new GYM()
                    .setName("אייקון פיטנס - אחד העם")
                    .setAddress("אחד העם 9, תל אביב")
                    .setPhoneNumber("+972 9-777-8870")
                    .setRating(4.3f)
                    .setPoster("https://image-url.com/ahad-haam")
                    .setLatitude(32.064755)
                    .setLongitude(34.770221)
                    .setCurrentExercisers(random.nextInt(70) + 1));

            gyms.add(new GYM()
                    .setName("אייקון פיטנס - נאות אפקה")
                    .setAddress("פנחס רוזן 65, תל אביב")
                    .setPhoneNumber("+972 9-777-8870")
                    .setRating(4.2f)
                    .setPoster("https://thumbs.dreamstime.com/b/man-working-out-battle-ropes-gym-muscular-man-working-out-battle-ropes-gym-wearing-black-shorts-321126720.jpg")
                    .setLatitude(32.113015)
                    .setLongitude(34.826798)
                    .setCurrentExercisers(random.nextInt(70) + 1));

            gyms.add(new GYM()
                    .setName("אייקון פיטנס - ויצמן")
                    .setAddress("רחוב ויצמן 14, תל אביב")
                    .setPhoneNumber("+972 9-777-8870")
                    .setRating(4.4f)
                    .setPoster("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTv1K1z7zxiJDKL5cZ9qUz3Vnt2dxtRSTQEpA&s")
                    .setLatitude(32.083261)
                    .setLongitude(34.788837)
                    .setCurrentExercisers(random.nextInt(70) + 1));


            gyms.add(new GYM()
                .setName("אייקון פיטנס נתניה")
                .setAddress("שדרות טום לנטוס 59, נתניה")
                .setPhoneNumber("+972 9-777-8870")
                .setRating(3.9f)
                .setPoster("https://paperwalls.co.za/wp-content/uploads/2023/06/brett-jordan-U2q73PfHFpM-unsplash-scaled.jpg")
                .setLatitude(32.332925)
                .setLongitude(34.859912)
                .setCurrentExercisers(random.nextInt(70) + 1));

        gyms.add(new GYM()
                .setName("אייקון פיטנס ירושלים")
                .setAddress("סינמה סיטי ירושלים, שדרות יצחק רבין")
                .setPhoneNumber("+972 9-777-8870")
                .setRating(4.4f)
                .setPoster("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQGRv_HAvqwgbKS_7wh5cyUZa23DzcMZeJrsw&s")
                .setLatitude(31.766663)
                .setLongitude(35.217018)
                .setCurrentExercisers(random.nextInt(70) + 1));

        gyms.add(new GYM()
                .setName("אייקון פיטנס אשדוד")
                .setAddress("בניין משרדים k שדרות ירושלים 18, אשדוד")
                .setPhoneNumber("+972 9-777-8870")
                .setRating(4.1f)
                .setPoster("https://i.pinimg.com/736x/03/d8/43/03d84326a3c2f94a188ac8ac81bd4a53.jpg")
                .setLatitude(31.810768)
                .setLongitude(34.654010)
                .setCurrentExercisers(random.nextInt(70) + 1));

        gyms.add(new GYM()
                .setName("אייקון פיטנס כפר סבא")
                .setAddress("מתחם U, היוצרים 2, כפר סבא")
                .setPhoneNumber("+972 9-777-8870")
                .setRating(4.1f)
                .setPoster("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT7Jv-Vc9bhvHcMer--DnDSCRO00u9kc9zfBA&s")
                .setLatitude(32.185982)
                .setLongitude(34.903340)
                .setCurrentExercisers(random.nextInt(70) + 1));

        gyms.add(new GYM()
                .setName("אייקון פיטנס אשקלון סיטי")
                .setAddress("שדרות דוד בן גוריון 7, אשקלון")
                .setPhoneNumber("+972 9-777-8870")
                .setRating(4.6f)
                .setPoster("https://media.istockphoto.com/id/1448303096/photo/gym-equipment-and-weights-of-fitness-background-for-exercise-training-or-heavy-workout-for.jpg?s=612x612&w=0&k=20&c=IUnGrKeIoHpDCMhA6MVxxJANZuKcrCIvAw5Mp5sONmo=")
                .setLatitude(31.679213)
                .setLongitude(34.573128)
                .setCurrentExercisers(random.nextInt(70) + 1));

        gyms.add(new GYM()
                .setName("אייקון פיטנס פרדס חנה")
                .setAddress("תחייה 14, פרדס חנה")
                .setPhoneNumber("+972 9-777-8870")
                .setRating(3.7f)
                .setPoster("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTj2e3PLl0fnZHA1NTSWXkL9-Kbu2acSWVxEA&s")
                .setLatitude(32.491529)
                .setLongitude(34.995095)
                .setCurrentExercisers(random.nextInt(70) + 1));

        gyms.add(new GYM()
                .setName("אייקון פיטנס באר שבע")
                .setAddress("תורת היחסות 11, באר שבע")
                .setPhoneNumber("+972 9-777-8870")
                .setRating(4.4f)
                .setPoster("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSeuJq4vwodqOlXrsDu0mwGglX99nSAoRw5Ww&s")
                .setLatitude(31.252350)
                .setLongitude(34.791586)
                .setCurrentExercisers(random.nextInt(70) + 1));

        gyms.add(new GYM()
                .setName("אייקון פיטנס באר שבע - בן גוריון")
                .setAddress("שדרות דוד בן גוריון 7, באר שבע")
                .setPhoneNumber("+972 9-777-8870")
                .setRating(4.2f)
                .setPoster("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTzAFb11bHwuL3_LogMxE_nw2U-ofyR6aMe1g&s")
                .setLatitude(31.248945)
                .setLongitude(34.791658)
                .setCurrentExercisers(random.nextInt(70) + 1));

        gyms.add(new GYM()
                .setName("אייקון פיטנס ראשון לציון - בן גוריון")
                .setAddress("דרך בן גוריון 147, ראשון לציון")
                .setPhoneNumber("+972 9-777-8870")
                .setRating(4.2f)
                .setPoster("https://watermark.lovepik.com/photo/40143/7821.jpg_wh1200.jpg")
                .setLatitude(31.968320)
                .setLongitude(34.783470)
                .setCurrentExercisers(random.nextInt(70) + 1));

        gyms.add(new GYM()
                .setName("אייקון פיטנס נהריה")
                .setAddress("השפלה 1, נהריה")
                .setPhoneNumber("+972 9-777-8870")
                .setRating(4.1f)
                .setPoster("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQGRv_HAvqwgbKS_7wh5cyUZa23DzcMZeJrsw&s")
                .setLatitude(33.007810)
                .setLongitude(35.100210)
                .setCurrentExercisers(random.nextInt(70) + 1));

        gyms.add(new GYM()
                .setName("אייקון פיטנס בת ים")
                .setAddress("יוספטל 92, בת ים")
                .setPhoneNumber("+972 9-777-8870")
                .setRating(3.6f)
                .setPoster("https://png.pngtree.com/background/20230610/original/pngtree-the-gym-scene-where-people-are-sitting-in-a-gym-picture-image_3108802.jpg")
                .setLatitude(32.023010)
                .setLongitude(34.750030)
                .setCurrentExercisers(random.nextInt(70) + 1));

        gyms.add(new GYM()
                .setName("אייקון פיטנס פתח תקווה")
                .setAddress("ז'בוטינסקי 92, פתח תקווה")
                .setPhoneNumber("+972 9-777-8870")
                .setRating(4.4f)
                .setPoster("https://www.wallart.com/media/catalog/product/cache/5b18b93ddbe5d6592c6b175f41d24454/w/0/w03193-small.jpg")
                .setLatitude(32.087210)
                .setLongitude(34.889880)
                .setCurrentExercisers(random.nextInt(70) + 1));

            gyms.add(new GYM()
                    .setName("אייקון פיטנס בית שאן")
                    .setAddress("מרכז צים אורבן, בית שאן")
                    .setPhoneNumber("+972 9-777-8870")
                    .setRating(4.5f)
                    .setPoster("https://www.primalstrength.com/cdn/shop/files/gymdesign_render_Two_collumn_grid_cb1b5850-fa8e-4a7b-a2b3-190c2e45facd.jpg?v=1680719688&width=1500") // Replace with the actual poster URL
                    .setLatitude(32.4973)
                    .setLongitude(35.4983)
                    .setCurrentExercisers(random.nextInt(70) + 1));

            gyms.add(new GYM()
                    .setName("אייקון פיטנס רעננה")
                    .setAddress("החרושת 10, רעננה")
                    .setPhoneNumber("+972 9-745-6501")
                    .setRating(4.5f)
                    .setPoster("https://img.freepik.com/free-photo/3d-gym-equipment_23-2151114163.jpg")
                    .setLatitude(32.1848)
                    .setLongitude(34.8713)
                    .setCurrentExercisers(random.nextInt(70) + 1));

            gyms.add(new GYM()
                    .setName("אייקון פיטנס חדרה")
                    .setAddress("הרברט סמואל 16, חדרה")
                    .setPhoneNumber("+972 9-777-8870")
                    .setRating(4.1f)
                    .setPoster("https://paperwalls.co.za/wp-content/uploads/2023/06/brett-jordan-U2q73PfHFpM-unsplash-scaled.jpg")
                    .setLatitude(32.4427)
                    .setLongitude(34.9167)
                    .setCurrentExercisers(random.nextInt(70) + 1));

            gyms.add(new GYM()
                    .setName("אייקון פיטנס הרצליה")
                    .setAddress("בן גוריון 8, הרצליה")
                    .setPhoneNumber("+972 9-954-5555")
                    .setRating(4.4f)
                    .setPoster("https://i.pinimg.com/736x/5b/d1/55/5bd155cb02cd30ae940cb17737ae0e78.jpg")
                    .setLatitude(32.1631)
                    .setLongitude(34.8436)
                    .setCurrentExercisers(random.nextInt(70) + 1));

            gyms.add(new GYM()
                    .setName("אייקון פיטנס טבריה")
                    .setAddress("המברג 1, טבריה")
                    .setPhoneNumber("+972 9-777-8870")
                    .setRating(4.5f)
                    .setPoster("https://i.pinimg.com/736x/03/d8/43/03d84326a3c2f94a188ac8ac81bd4a53.jpg")
                    .setLatitude(32.7891)
                    .setLongitude(35.5299)
                    .setCurrentExercisers(random.nextInt(70) + 1));

            gyms.add(new GYM()
                    .setName("אייקון פיטנס עכו")
                    .setAddress("רחוב בן עמי 6, עכו")
                    .setPhoneNumber("+972 9-777-8870")
                    .setRating(4.4f)
                    .setPoster("https://i.pinimg.com/736x/49/e8/a2/49e8a2f874cffe0e4e9c6926fb3756b5.jpg")
                    .setLatitude(32.9289)
                    .setLongitude(35.0816)
                    .setCurrentExercisers(random.nextInt(70) + 1));

            gyms.add(new GYM()
                    .setName("אייקון פיטנס כרמיאל")
                    .setAddress("קניון חוצות כרמיאל, כרמיאל")
                    .setPhoneNumber("+972 9-777-8870")
                    .setRating(4.2f)
                    .setPoster("https://media.istockphoto.com/id/1448303096/photo/gym-equipment-and-weights-of-fitness-background-for-exercise-training-or-heavy-workout-for.jpg?s=612x612&w=0&k=20&c=IUnGrKeIoHpDCMhA6MVxxJANZuKcrCIvAw5Mp5sONmo=")
                    .setLatitude(32.9228)
                    .setLongitude(35.2971)
                    .setCurrentExercisers(random.nextInt(70) + 1));

            gyms.add(new GYM()
                    .setName("אייקון פיטנס מעלות")
                    .setAddress("מרכז ביג מעלות, מעלות תרשיחא")
                    .setPhoneNumber("+972 9-777-8870")
                    .setRating(4.1f)
                    .setPoster("https://static.vecteezy.com/system/resources/previews/031/597/022/non_2x/the-gym-features-rows-of-dumbbells-offering-a-wide-range-of-weights-vertical-mobile-wallpaper-ai-generated-free-photo.jpg")
                    .setLatitude(32.9963)
                    .setLongitude(35.2727)
                    .setCurrentExercisers(random.nextInt(70) + 1));


            gyms.add(new GYM()
                    .setName("אייקון פיטנס קרית מוצקין")
                    .setAddress("קריון, קרית מוצקין")
                    .setPhoneNumber("+972 9-777-8870")
                    .setRating(4.1f)
                    .setPoster("https://png.pngtree.com/thumb_back/fh260/background/20230613/pngtree-black-and-white-gym-room-with-a-row-of-equipment-image_2911173.jpg")
                    .setLatitude(32.8324)
                    .setLongitude(35.0808)
                    .setCurrentExercisers(random.nextInt(70) + 1));

            gyms.add(new GYM()
                    .setName("אייקון פיטנס עפולה")
                    .setAddress("יהושע חנקין 14, עפולה")
                    .setPhoneNumber("+972 9-777-8870")
                    .setRating(4.5f)
                    .setPoster("https://www.auraclesound.co.uk/wp-content/uploads/2020/12/Background-Music-for-Gym-scaled.jpg")
                    .setLatitude(32.592334)
                    .setLongitude(35.294730)
                    .setCurrentExercisers(random.nextInt(70) + 1));

        gyms.add(new GYM()
                .setName("אייקון פיטנס אילת")
                .setAddress("לוטוס 5, אילת")
                .setPhoneNumber("+972 9-777-8870")
                .setRating(4.0f)
                .setPoster("https://media.istockphoto.com/id/1448303096/photo/gym-equipment-and-weights-of-fitness-background-for-exercise-training-or-heavy-workout-for.jpg?s=612x612&w=0&k=20&c=IUnGrKeIoHpDCMhA6MVxxJANZuKcrCIvAw5Mp5sONmo=")
                .setLatitude(29.558050)
                .setLongitude(34.948210)
                .setCurrentExercisers(random.nextInt(70) + 1));


        gyms.add(new GYM()
                .setName("אייקון פיטנס דימונה")
                .setAddress("גולדה מאיר 1, דימונה")
                .setPhoneNumber("+972 9-777-8870")
                .setRating(4.1f)
                .setPoster("https://static.vecteezy.com/system/resources/previews/031/596/927/non_2x/neatly-organized-rows-of-dumbbells-await-gym-goers-for-diverse-weightlifting-exercises-vertical-mobile-wallpaper-ai-generated-free-photo.jpg")
                .setLatitude(31.066900)
                .setLongitude(35.030600)
                .setCurrentExercisers(random.nextInt(70) + 1));

            gyms.add(new GYM()
                    .setName("אייקון פיטנס זכרון יעקב")
                    .setAddress("דרך מלאכי השלום 1, זכרון יעקב")
                    .setPhoneNumber("+972 9-777-8870")
                    .setRating(4.3f)
                    .setPoster("https://c1.wallpaperflare.com/preview/296/691/592/training-sport-fit-sporty.jpg")
                    .setLatitude(32.572260)
                    .setLongitude(34.954392)
                    .setCurrentExercisers(random.nextInt(70) + 1));

        gyms.add(new GYM()
                .setName("אייקון פיטנס קריית אונו")
                .setAddress("ירושלים בלבד 39, קריית אונו")
                .setPhoneNumber("+972 9-777-8870")
                .setRating(4.2f)
                .setPoster("https://i.pinimg.com/736x/5b/d1/55/5bd155cb02cd30ae940cb17737ae0e78.jpg")
                .setLatitude(32.0510)
                .setLongitude(34.8531)
                .setCurrentExercisers(random.nextInt(70) + 1));

        startRandomUpdater();
        }

        return gyms;
    }

    private static void startRandomUpdater() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                for (GYM gym : gyms) {
                    gym.setCurrentExercisers(random.nextInt(70) + 1);
                }
                handler.postDelayed(this, 10000);
            }
        }, 10000);
    }

    public static void saveFavorites(Context context, List<GYM> gyms) {
        SharedPreferences preferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(gyms);
        editor.putString(FAVORITES_KEY, json);
        editor.apply();
    }

    public static List<GYM> loadFavorites(Context context) {
        SharedPreferences preferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = preferences.getString(FAVORITES_KEY, null);
        Type type = new TypeToken<ArrayList<GYM>>() {}.getType();
        List<GYM> gyms = gson.fromJson(json, type);
        if (gyms == null) {
            gyms = new ArrayList<>();
        }
        return gyms;
    }

    public static void updateFavorites(Context context, GYM gym) {
        List<GYM> gyms = loadFavorites(context);
        boolean exists = false;

        for (GYM g : gyms) {
            if (g.getAddress().equals(gym.getAddress())) {
                if (!gym.isFavorite()) {
                    gyms.remove(g);
                } else {
                    g.setFavorite(true);
                }
                exists = true;
                break;
            }
        }
        if (!exists && gym.isFavorite()) {
            gyms.add(gym);
        }
        saveFavorites(context, gyms);
    }
}

