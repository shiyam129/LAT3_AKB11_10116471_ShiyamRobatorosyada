package shiyam.akb11.com;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import shiyam.akb11.com.Adapter.GalleryAdapter;
import shiyam.akb11.com.Model.GalleryModel;
import shiyam.akb11.com.R;


/**
 * A simple {@link Fragment} subclass.
 */public class FragmentGallery extends Fragment {


    private RecyclerView mRecycleView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View myFragmentView = inflater.inflate(R.layout.fragment_gallery, container, false);
        ArrayList<GalleryModel> galleryModels = new ArrayList<>();
        galleryModels.add(new GalleryModel(R.drawable.gambar_shiyam));
        galleryModels.add(new GalleryModel(R.drawable.gambar_shiyam2));
        galleryModels.add(new GalleryModel(R.drawable.gambar_shiyam3));
        galleryModels.add(new GalleryModel(R.drawable.gambar_shiyam4));

        mRecycleView = myFragmentView.findViewById(R.id.recyclerViewGrid);
        mRecycleView.setHasFixedSize(true);
        mLayoutManager = new GridLayoutManager(getActivity(),3);
        mAdapter = new GalleryAdapter(galleryModels);

        mRecycleView.setLayoutManager(mLayoutManager);
        mRecycleView.setAdapter(mAdapter);
        return myFragmentView;
    }

}
