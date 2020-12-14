package cl.evilcorp.miraza.fragmentsAndAdapters;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cl.evilcorp.miraza.R;
import cl.evilcorp.miraza.databinding.FragmentImageBinding;
import cl.evilcorp.miraza.model.BreedModel;
import cl.evilcorp.miraza.presenter.IBreedPresenter;
import cl.evilcorp.miraza.presenter.ImgPresenter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ImageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ImageFragment extends Fragment implements IBreedPresenter, OnItemLongClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
   private static final String ARG_PARAM1 = "param1";
   private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private TextView tvBreed3;
    private ImgPresenter presenter;
    private ImageAdapter adapter;
    private RecyclerView recyclerView;
    private FragmentImageBinding binding;

    public ImageFragment() {
        // Required empty public constructor
    }


    public static ImageFragment newInstance(String param1, String param2) {
        ImageFragment fragment = new ImageFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding=FragmentImageBinding.inflate(inflater,container, false);
        View view = binding.getRoot();

        tvBreed3 =binding.textView;
        tvBreed3.setText(getString(R.string.ImgTitle)+mParam2.toUpperCase());
        adapter=new ImageAdapter(new ArrayList<>(),this);
        presenter =new ImgPresenter(this,new BreedModel(),mParam2);
        recyclerView=binding.imageRecicler;
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        recyclerView.setAdapter(adapter);
        return view;
    }


   @Override
   public void onDestroyView() {
       super.onDestroyView();
       binding=null;
   }
    @Override
    public void onLongClick(int position) {

    }

    @Override
    public void showBreed(List<String> breeds) {adapter.updateImages(breeds);

    }
}