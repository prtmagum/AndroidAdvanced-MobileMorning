package com.example.workmngr;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class MyWorker extends Worker {

    public MyWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        // Menampilkan pesan di log
        // Misalnya, kita akan mencetak pesan ke log setiap kali pekerjaan dijalankan
        android.util.Log.d("MyWorker", "Aplikasi ini sedang berjalan dilatar belakang");

        // Return Result.success() jika pekerjaan berhasil
        return Result.success();
    }
}

