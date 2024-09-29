package com.example.smallapp.main.db;

import android.provider.BaseColumns;


public final class TicTacContract {
    private TicTacContract() {
    }

    public static final String SQL_DELETE_ENTRIES = TicTacContract.SQL_DELETE_PLAYER + ";" + TicTacContract.SQL_DELETE_HISTORY;
    public static final String SQL_DELETE_PLAYER =
            "DROP TABLE IF EXISTS " + Player.TABLE_NAME;
    public static final String SQL_DELETE_HISTORY =
            "DROP TABLE IF EXISTS " + History.TABLE_NAME;

    public static final String SQL_CREATE_ENTRIES = TicTacContract.SQL_PLAYER_TABLE + ";" +  TicTacContract.SQL_HISTORY_TABLE;
    public static final String SQL_PLAYER_TABLE =
            "CREATE TABLE " + Player.TABLE_NAME + " (" +
                    Player._ID + " INTEGER PRIMARY KEY," +
                    Player.COL_NAME + " TEXT, " +
                    Player.COL_MATCHES_WON + " INTEGER," +
                    Player.COL_MATCHES_PLAYED + " INTEGER)";
    static public final String SQL_HISTORY_TABLE =
            "CREATE TABLE " + History.TABLE_NAME + " (" +
                    History._ID + " INTEGER PRIMARY KEY," +
                    History.COL_PLAYER_ONE_ID + " INTEGER," +
                    History.COL_PLAYER_TWO_ID + " INTEGER," +
                    History.COL_MOVES_COUNT + " INTEGER," +
                    History.COL_WINNER_ID + " INTEGER," +
                    History.COL_PLAYED_ON + " DATETIME," +
                    History.COL_DRAW + " BOOL," +
                    "CONSTRAINT player_one_id_fk FOREIGN KEY (player_one_id) REFERENCES player (_id),\n" +
                    "CONSTRAINT player_tow_id_fk FOREIGN KEY (player_two_id) REFERENCES player (_id),\n" +
                    "CONSTRAINT winner_id_fk FOREIGN KEY (winner_id) REFERENCES player (_id)\n" +
                    ")";

    public static class Player implements BaseColumns {
        public static final String TABLE_NAME = "player";
        public static final String COL_NAME = "name";
        public static final String COL_MATCHES_WON = "matches_won";
        public static final String COL_MATCHES_PLAYED = "matches_played";
    }

    public static class History implements BaseColumns {
        public static final String TABLE_NAME = "history";
        public static final String COL_PLAYER_ONE_ID = "player_one_id";
        public static final String COL_PLAYER_TWO_ID = "player_two_id";
        public static final String COL_MOVES_COUNT = "moves_count";
        public static final String COL_WINNER_ID = "winner_id";
        public static final String COL_PLAYED_ON = "played_on";
        public static final String COL_DRAW = "draw";
    }
}
