/*
 * Copyright 2018 ThoughtWorks, Inc.
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

package com.thoughtworks.go.apiv1.stageoperations.representers;

import com.thoughtworks.go.api.base.OutputWriter;
import com.thoughtworks.go.presentation.pipelinehistory.StageHistoryModel;
import com.thoughtworks.go.spark.Routes;

public class PaginationRepresenter {
    public static void toJSON(OutputWriter jsonWriter, StageHistoryModel stageHistoryModel) {
        int pageSize = stageHistoryModel.getStageInstanceModels().size();
        jsonWriter.add("page_size", pageSize);
        if (pageSize >= 10) {
            jsonWriter.add("next_cursor", stageHistoryModel.getNextCursor());
            jsonWriter.addLinks(linksWriter -> linksWriter.addLink("next_page", Routes.Stage.stageHistory(stageHistoryModel.getPipelineName(), stageHistoryModel.getStageName(), stageHistoryModel.getNextCursor())));
        }
    }
}
