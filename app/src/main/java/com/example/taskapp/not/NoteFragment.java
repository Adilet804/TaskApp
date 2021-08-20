package com.example.taskapp.not;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.taskapp.R;
import com.example.taskapp.databinding.FragmentNoteBinding;
import com.example.taskapp.utils.Constants;


public class NoteFragment extends Fragment {
    FragmentNoteBinding binding;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentNoteBinding.inflate(inflater,container,false);
        initView();
        return binding.getRoot();


    }

    private void initView() {
        binding.btnSave.setOnClickListener(v -> {
            String title = binding.editText.getText().toString().trim();
            if (TextUtils.isEmpty(title)) {
                binding.editText.setError("Вы не правильно ввели");
                return;
            }else {
                Bundle bundle = new Bundle();
                bundle.putString(Constants.BUNDLE_KEY, title);
                getParentFragmentManager().setFragmentResult(Constants.REQUEST_KEY, bundle);
            }

            close();
        });
    }


    private void close() {
        NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment_content_main);
        navController.navigateUp();
    }

}