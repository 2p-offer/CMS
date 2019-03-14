package com.wy.manager.mp.analysisplatform.api;

/**
 * 分析总数据
 * Created by 2P on 19-3-14.
 */
public class AnalysisArgs {
    private BiologicalArgs biologicalArgs;

    private HydrologyArgs hydrologyArgs;

    private MeteorologicalArgs meteorologicalArgs;

    private SoilArgs soilArgs;

    private WaterQualityArgs waterQualityArgs;

    //社会经济
    private String socioeconomic;

    public BiologicalArgs getBiologicalArgs() {
        return biologicalArgs;
    }

    public void setBiologicalArgs(BiologicalArgs biologicalArgs) {
        this.biologicalArgs = biologicalArgs;
    }

    public HydrologyArgs getHydrologyArgs() {
        return hydrologyArgs;
    }

    public void setHydrologyArgs(HydrologyArgs hydrologyArgs) {
        this.hydrologyArgs = hydrologyArgs;
    }

    public MeteorologicalArgs getMeteorologicalArgs() {
        return meteorologicalArgs;
    }

    public void setMeteorologicalArgs(MeteorologicalArgs meteorologicalArgs) {
        this.meteorologicalArgs = meteorologicalArgs;
    }

    public SoilArgs getSoilArgs() {
        return soilArgs;
    }

    public void setSoilArgs(SoilArgs soilArgs) {
        this.soilArgs = soilArgs;
    }

    public WaterQualityArgs getWaterQualityArgs() {
        return waterQualityArgs;
    }

    public void setWaterQualityArgs(WaterQualityArgs waterQualityArgs) {
        this.waterQualityArgs = waterQualityArgs;
    }

    public String getSocioeconomic() {
        return socioeconomic;
    }

    public void setSocioeconomic(String socioeconomic) {
        this.socioeconomic = socioeconomic;
    }

    public static void main(String[] args) {

    }
}
