package com.example.android.miwok;

import android.view.View;

import java.util.ArrayList;

public class Word {
    public static final int NO_IMAGE_PROVIDED = -1;

    String sMiwokTranslation;
    String sDefaultTranslation;
    int iImageId = NO_IMAGE_PROVIDED;


    public Word(String miwokWord, String englishWord)
    {
        sMiwokTranslation = miwokWord;
        sDefaultTranslation = englishWord;
        iImageId = NO_IMAGE_PROVIDED;
    }

    public Word(String miwokWord, String englishWord, int imageId)
    {
        sMiwokTranslation = miwokWord;
        sDefaultTranslation = englishWord;
        iImageId = imageId;
    }

    public String getMiwokTranslation()
    {
        return sMiwokTranslation;
    }

    public String getDefaultTranslation()
    {
        return sDefaultTranslation;
    }

    public void setMiwokWord(String word)
    {
        sMiwokTranslation = word;
    }

    public String getEnglishWord()
    {
        return sDefaultTranslation;
    }

    public int getImageId()
    {
        return iImageId;
    }
}
