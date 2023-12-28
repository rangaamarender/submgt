package com.lucid.tenant.data;

import java.time.Month;
import java.util.Map;

public class DashBoardTenantsCountsVO {

    private Long activeTenantsCount;

    private Long inActiveTenantsCount;

    private Long expiringTenantsCount;

    private Long totalTenantsCount;


    private Map<String,Map<String,Long>> tenantsCountsForGraph;


    /**
     * Create a new <code>DashBoardTenantsCountsVO</code>
     */

    public DashBoardTenantsCountsVO(){
        super();
    }

    /**
     * @return  activeTenantsCount
     */
    public Long getActiveTenantsCount() {
        return activeTenantsCount;
    }

    /**
     * @param activeTenantsCount to set activeTenantsCount
     */
    public void setActiveTenantsCount(Long activeTenantsCount) {
        this.activeTenantsCount = activeTenantsCount;
    }

    /**
     * @return  inactiveTenantsCount
     */
    public Long getInActiveTenantsCount() {
        return inActiveTenantsCount;
    }


    /**
     * @param inActiveTenantsCount to set inActiveTenantsCount
     */
    public void setInActiveTenantsCount(Long inActiveTenantsCount) {
        this.inActiveTenantsCount = inActiveTenantsCount;
    }

    /**
     * @return expiringTenantsCount
     */
    public Long getExpiringTenantsCount() {
        return expiringTenantsCount;
    }

    /**
     *
     * @param expiringTenantsCount to set expiringTenantsCount
     */
    public void setExpiringTenantsCount(Long expiringTenantsCount) {
        this.expiringTenantsCount = expiringTenantsCount;
    }

    /**
     * @return totalTenantsCount
     */
    public Long getTotalTenantsCount() {
        return totalTenantsCount;
    }

    /**
     *
     * @param totalTenantsCount to set totalTenantsCount
     */
    public void setTotalTenantsCount(Long totalTenantsCount) {
        this.totalTenantsCount = totalTenantsCount;
    }

    /**
     * @return tenantsGraphsCount month wise
     */
    public Map<String,Map<String,Long>> getTenantsCountsForGraph() {
        return tenantsCountsForGraph;
    }

    /**
     * @param tenantsCountsForGraph
     */
    public void setTenantsCountsForGraph(Map<String, Map<String,Long>> tenantsCountsForGraph) {
        this.tenantsCountsForGraph = tenantsCountsForGraph;
    }
}
