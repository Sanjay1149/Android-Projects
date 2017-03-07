package io.iqube.kctgrad;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sanjaypradeep on 23-09-2016.
 */
public class participants extends Fragment {
    private List<ParticipantsContent> contentList;
    private RecyclerView recyclerView;
    private ParticipantsRecyclerViewAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        contentList = new ArrayList<>();
        View v = inflater.inflate(R.layout.fragment_about_guest, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.recycler_view);
        adapter = new ParticipantsRecyclerViewAdapter(contentList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        // new Download().execute(URL);
        prepareParticipantData(" Bharat S\n C. S. Abhishek\n K.Harish Krishana\n Keerthana S.\n Manasa Krishnan","Electronic Timed Assistant","Rajalakshmi Engineering College");
        prepareParticipantData(" Weda Thanthrige\n Viduranga Lahiru Gunarathne\n Gajanayaka Sidath Chandima\n Perera Hettikankanamalage Pavithra","SpecBuddy - Smart embedded system for the visually impaired","General Sir John Kotelawala");
        prepareParticipantData(" John Maria Vivian\n Naveen Winson\n Solomon Azariah\n Gnana Kousalya C.\n Manoharan P. A.\n rohini G.\n Akilandeswari A.","Humanoid robot"," St. Joseph's Institute of Technology");
        prepareParticipantData(" S. Muhammed Humaid\n D. Manish\n P. S. Manoj\n R. Kumaraguru\n M.Kaushik Krishna","Hygebot","Rajalaskmi Engineering College");
        prepareParticipantData(" Adarsh V. George\n Asihwarya T. V\n Akhila D.\n Alisha P. K.\n Fathima Rinza","Life Jacket","Sahradaya College of Engineering");
        prepareParticipantData(" Mohana M.\n S. Megam","Music Player controller","Kumaraguru College of Technology");
        prepareParticipantData(" Meena P.\n Lavanya R.","Power Walk","Kumaraguru College of Technology");
        prepareParticipantData(" Insaf Ismath","Project Access","University of Moratuwa");
        prepareParticipantData(" Soundarya L\n Sounder R.","Serbot","");
        prepareParticipantData(" NishanthKumar S.\n Rajeshkumar R.","Smart indoor green house managemnet in hospitals","Kumaraguru College of Technology");
        prepareParticipantData(" Vignesh R\n Surya Prabha N","Control of multiple submersible motors using Micro controller to avoid dry run","Bannari Amman Institute of Technology");
        prepareParticipantData(" Shyam Sundar C.\n Sharath K\n Sathiya K","Smart Network","");
        prepareParticipantData(" Dharani Dharan","Smart stick with ultrasonic sensor","Kumaraguru College of Technology");
        prepareParticipantData(" V. C. Kavya\n r.Jeni Sakthi\n K. G. Likhitha\n R. Kiruthiga\n B. Kushal Singh","Movement Capturing and Help Sekking Device for Diasbled People","Rajalakshmi College of Technology");
        prepareParticipantData(" Prem Kumar T.G.\n Saravanan S","Automatic energy saver for semiar Halls using arduino processor","Bannari Amman Institute of Technology");
        prepareParticipantData(" Muhammad Farhan Khan\n Muhammad Hassam\n Sani Syed Muhammad\n Saad hussain","Automation of Fabric Inspection Machine using Digital Image Processing","Usman Institue of Technology");
        prepareParticipantData(" Santhos S\n Rajeshwar E."," Green Power generation using calcium carbide","Bannari Amman Institute of Technology");

        return v;
    }
    public void prepareParticipantData(String participant_name,String Project_name, String college_name){
        ParticipantsContent content = new ParticipantsContent(participant_name,Project_name,college_name);
        contentList.add(content);
        adapter.notifyDataSetChanged();
    }
    public participants() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    public static participants newInstance() {
        participants fragment = new participants();

        return fragment;
    }

}
