package fr.sio.ecp.federatedbirds.app;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.os.AsyncTaskCompat;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;

import fr.sio.ecp.federatedbirds.ApiClient;
import fr.sio.ecp.federatedbirds.R;
import fr.sio.ecp.federatedbirds.auth.TokenManager;

/**
 * Created by Michaël on 30/11/2015.
 */
public class ImageGalleryTaskFragment extends DialogFragment {

    private static final String ARG_AVATAR = "avatar";

    public void setArguments(byte[] avatar) {
        Bundle args = new Bundle();
        args.putByteArray(ImageGalleryTaskFragment.ARG_AVATAR, avatar);
        setArguments(args);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        AsyncTaskCompat.executeParallel(
                new ImageGalleryTaskFragment.UploadAvatar()
        );
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        ProgressDialog dialog = new ProgressDialog(getContext());
        dialog.setIndeterminate(true);
        dialog.setMessage("Upload Avatar en cours ...");
        return dialog;
    }

    private class UploadAvatar extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... params) {
            try {
                byte[] avatar = getArguments().getByteArray(ImageGalleryTaskFragment.ARG_AVATAR);
                return ApiClient.getInstance(getContext()).uploadAvatar(avatar);
            } catch (IOException e) {
                Log.e(LoginActivity.class.getSimpleName(), "upload avatar failed!", e);
                return null;
            }
        }

        @Override
        protected void onPostExecute(String avatarUrl) {
            if (avatarUrl != null) {
                //TokenManager.setUserToken(getContext(), token);
                getActivity().finish();
                startActivity(MainActivity.newIntent(getContext()));
                Toast.makeText(getContext(), "Upload avatar effectué avec succés !", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getContext(), "upload avatar a échoué!", Toast.LENGTH_SHORT).show();
            }
            dismiss();
        }
    }
}
