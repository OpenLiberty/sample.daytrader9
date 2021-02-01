package com.ibm.websphere.samples.daytrader.interfaces;

import com.ibm.websphere.samples.daytrader.beans.RunStatsDataBean;

public interface TradeDB {
  
  /**
   * Reset the TradeData by - removing all newly registered users by scenario
   * servlet (i.e. users with userID's beginning with "ru:") * - removing all
   * buy/sell order pairs - setting logoutCount = loginCount
   *
   * return statistics for this benchmark run
   */
  RunStatsDataBean resetTrade(boolean deleteAll) throws Exception;

  /**
   * Get the Database Product Name
   *
   * return DB Product Name String
   */
  String checkDBProductName() throws Exception;

  /**
   * Get the impl for the TradeService
   *
   * return int matching the implementation
   */

}
