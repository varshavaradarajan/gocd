/*
 * Copyright 2019 ThoughtWorks, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.thoughtworks.go.presentation.pipelinehistory;

public class StageHistoryModel {
    private StageInstanceModels stageInstanceModels;
    private long nextCursor;
    private String pipelineName;
    private String stageName;

    public StageHistoryModel(StageInstanceModels stageInstanceModels, long nextCursor) {
        this.stageInstanceModels = stageInstanceModels;
        this.nextCursor = nextCursor;
    }

    public StageInstanceModels getStageInstanceModels() {
        return stageInstanceModels;
    }

    public void setStageInstanceModels(StageInstanceModels stageInstanceModels) {
        this.stageInstanceModels = stageInstanceModels;
    }

    public long getNextCursor() {
        return nextCursor;
    }

    public void setNextCursor(long nextCursor) {
        this.nextCursor = nextCursor;
    }

    public String getPipelineName() {
        return pipelineName;
    }

    public void setPipelineName(String pipelineName) {
        this.pipelineName = pipelineName;
    }

    public String getStageName() {
        return stageName;
    }

    public void setStageName(String stageName) {
        this.stageName = stageName;
    }
}
