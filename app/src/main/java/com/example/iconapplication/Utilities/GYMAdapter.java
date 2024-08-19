package com.example.iconapplication.Utilities;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.iconapplication.Models.GYM;
import com.example.iconapplication.R;

import java.util.ArrayList;
import java.util.List;

public class GYMAdapter extends RecyclerView.Adapter<GYMAdapter.GYMViewHolder> {

    private List<GYM> gyms;
    private Context context;

    public GYMAdapter(List<GYM> gyms, Context context) {
        this.gyms = gyms;
        this.context = context;
    }

    @NonNull
    @Override
    public GYMViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.horizontal_gym_item, parent, false);
        return new GYMViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GYMViewHolder holder, int position) {
        GYM gym = gyms.get(position);

        // הגדרת תצוגת הפריטים
        holder.gym_LBL_name.setText(gym.getName());
        holder.gym_LBL_phone.setText(gym.getPhoneNumber());
        holder.gym_LBL_address.setText(gym.getAddress());
        holder.gym_RTNG_rating.setRating(gym.getRating());

        // הגדרת תמונת פוסטר והאם הוא מועדף (סימן הלב)
        ImageLoader.load(gym.getPoster(), holder.gym_IMG_poster); // לדוגמה

        holder.gym_IMG_favorite.setImageResource(gym.isFavorite() ? R.drawable.heart : R.drawable.empty_heart);

        // הגדרת OnClickListener לפריט
        holder.itemView.setOnClickListener(v -> {
            int currentExercisers = gym.getCurrentExercisers();
            String loadLevel = currentExercisers > 30 ? "רמת העומס גבוהה \uD83D\uDEA8\n" : "רמת העומס נמוכה \uD83C\uDFCB\uD83C\uDFFD\n";
            String message = "כמות מתאמנים: " + currentExercisers + " \n " + loadLevel;

            Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
        });

        // הגדרת OnClickListener לאייקון הלב
        holder.gym_IMG_favorite.setOnClickListener(v -> {
            gym.setFavorite(!gym.isFavorite());
            DataManager.updateFavorites(context, gym);
            notifyItemChanged(position); // עדכן את הפריט הנוכחי ברשימה
        });

        // הגדרת OnClickListener לאייקון הטלפון
        holder.gym_IMG_phone.setOnClickListener(v -> {
            String phoneNumber = gym.getPhoneNumber();
            if (phoneNumber != null && !phoneNumber.isEmpty()) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + phoneNumber));
                context.startActivity(intent);
            } else {
                Toast.makeText(context, "מספר טלפון לא זמין", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return gyms.size();
    }

    // פונקציה לעדכון הרשימה לאחר סינון
    public void updateList(List<GYM> newGyms) {
        gyms = new ArrayList<>(newGyms); // עדכון הרשימה עם הנתונים המסוננים
        notifyDataSetChanged(); // הודעה למתאם שהנתונים השתנו
    }

    public static class GYMViewHolder extends RecyclerView.ViewHolder {
        private com.google.android.material.textview.MaterialTextView gym_LBL_name;
        private com.google.android.material.textview.MaterialTextView gym_LBL_phone;
        private com.google.android.material.textview.MaterialTextView gym_LBL_address;
        private com.google.android.material.imageview.ShapeableImageView gym_IMG_favorite;
        private androidx.appcompat.widget.AppCompatRatingBar gym_RTNG_rating;
        private com.google.android.material.imageview.ShapeableImageView gym_IMG_poster;
        private com.google.android.material.imageview.ShapeableImageView gym_IMG_phone;

        public GYMViewHolder(@NonNull View itemView) {
            super(itemView);

            // קישור הפריטים בתצוגה
            gym_LBL_name = itemView.findViewById(R.id.gym_LBL_name);
            gym_LBL_phone = itemView.findViewById(R.id.gym_LBL_phone);
            gym_LBL_address = itemView.findViewById(R.id.gym_LBL_address);
            gym_IMG_favorite = itemView.findViewById(R.id.gym_IMG_favorite);
            gym_RTNG_rating = itemView.findViewById(R.id.gym_RTNG_rating);
            gym_IMG_poster = itemView.findViewById(R.id.gym_IMG_poster);
            gym_IMG_phone = itemView.findViewById(R.id.gym_IMG_phone); // קישור לאייקון הטלפון
        }
    }
}
