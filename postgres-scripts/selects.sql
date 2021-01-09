\c betting_db;



      SELECT COUNT(bp.betting_pick_id)
                      AS gespielteWetten,
             COUNT(bp.betting_pick_result)
                      AS gewonnenePunkte
            FROM betting_picks bp
            WHERE bp.user_name = 'dbadmin1';
