package shiyam.akb11.com;


import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentProfil extends Fragment {


    public FragmentProfil() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View myFragmentView = inflater.inflate(R.layout.fragment_profil, container, false);

        TextView txtNomer = (TextView)myFragmentView.findViewById(R.id.nomorhandphone);
        TextView txtIsnta = (TextView)myFragmentView.findViewById(R.id.instagram);
        TextView txtgmail = (TextView)myFragmentView.findViewById(R.id.gmail);
        Button btnMaps = (Button)myFragmentView.findViewById((R.id.btn_toMaps));



        txtNomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String formattedNumber = "089673952197";
                try{
                    Intent sendIntent =new Intent("android.intent.action.MAIN");
                    sendIntent.setComponent(new ComponentName("com.whatsapp", "com.whatsapp.Conversation"));
                    sendIntent.setAction(Intent.ACTION_SEND);
                    sendIntent.setType("text/plain");
                    sendIntent.putExtra(Intent.EXTRA_TEXT,"");
                    sendIntent.putExtra("jid", formattedNumber +"@s.whatsapp.net");
                    sendIntent.setPackage("com.whatsapp");
                    startActivity(sendIntent);
                }
                catch(Exception e)
                {
                    Toast.makeText(myFragmentView.getContext(),"Error/n"+ e.toString(),Toast.LENGTH_SHORT).show();
                }

            }
        });

        txtIsnta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent("android.intent.action.VIEW",

                        Uri.parse("https://www.instagram.com/shiyam_rosyada0414/?hl=id"));

                startActivity(browserIntent);


            }
        });
        txtgmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("plain/text");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[] { "shiyamrobator@gmail.com" });
                startActivity(Intent.createChooser(intent, ""));
            }
        });
        btnMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                        Uri.parse("https://www.google.com/maps/place/Sukaraja+Wetan,+Jatiwangi,+Kabupaten+Majalengka,+Jawa+Barat/@-6.7816037,108.2611364,14z/data=!4m5!3m4!1s0x2e6f265379922b9d:0x8c88932c8914e144!8m2!3d-6.7819653!4d108.2763069"));
                startActivity(intent);
            }
        });
        return myFragmentView;
    }
}
