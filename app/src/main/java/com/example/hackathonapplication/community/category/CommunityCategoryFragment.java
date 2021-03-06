package com.example.hackathonapplication.community.category;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.hackathonapplication.R;
import com.example.hackathonapplication.community.board.Post;
import com.example.hackathonapplication.community.board.PostAdapter;
import com.example.hackathonapplication.community.main.CommunityMainFragment;
import com.example.hackathonapplication.community.main.CommunityWriteFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CommunityCategoryFragment extends Fragment {
    private ViewGroup viewGroup;
    private Context context;
    private ArrayList<Post> dataSet;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private PostAdapter adapter;
    private ImageButton backButton;
    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;
    private FloatingActionButton writePostButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewGroup = (ViewGroup) inflater.inflate(R.layout.community_category_fragment, container, false);
        context = container.getContext();
        fragmentManager = getFragmentManager();

        initView();

        return viewGroup;
    }

    private void initView() {

        dataSet = new ArrayList<>();
        dataSet.add(new Post("김노인", "로그인구현후", "로그인구현후", "뱃지구현후", "언제쯤다되냐","2시간 전","3","3"));
        dataSet.add(new Post("김노인", "로그인구현후", "로그인구현후", "뱃지구현후", "언제쯤다되냐","2시간 전","3","3"));


        recyclerView = viewGroup.findViewById(R.id.rv_post);
        adapter = new PostAdapter(context, dataSet,fragmentManager);
        layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);

        backButton = viewGroup.findViewById(R.id.ib_back);
        writePostButton = viewGroup.findViewById(R.id.fab_writeButton);
        backButton.setOnClickListener(v -> onClick(v));
        writePostButton.setOnClickListener(v->onClick(v));

    }

    private void onClick(View v) {
        switch (v.getId()) {
            case R.id.ib_back:
                replaceFragment(new CommunityMainFragment());
                break;
            case R.id.fab_writeButton:
                replaceFragment(new CommunityWriteFragment());
        }

    }

    private void replaceFragment(Fragment fragment) {
        fragmentManager = getFragmentManager();
        transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frameLayout, fragment).commitAllowingStateLoss();               // Fragment로 사용할 MainActivity내의 layout공간을 선택합니다.

    }
}
