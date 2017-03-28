package com.islavstan.irregularverbs.model;

import com.google.firebase.database.IgnoreExtraProperties;


@IgnoreExtraProperties
public class Words {
    public String infinitive;
    public String pastParticiple;
    public String pastSimple;
    public String translate;

    public String getInfinitive() {
        return infinitive;
    }

    public String getPastParticiple() {
        return pastParticiple;
    }

    public String getPastSimple() {
        return pastSimple;
    }

    public String getTranslate() {
        return translate;
    }

    @Override
    public String toString() {
        return "Words{" +
                "infinitive='" + infinitive + '\'' +
                ", pastParticiple='" + pastParticiple + '\'' +
                ", pastSimple='" + pastSimple + '\'' +
                ", translate='" + translate + '\'' +
                '}';
    }
}
