class OverviewListItem {
    gameId: number;
    title: string;
    gameDescription: string;
    releasesCount: number;
    firstReleaseDate: Date;
}

class OverviewListPage {
    overviewList: OverviewListItem[];
    pageNumber: number;
    pageSize: number;
    totalItemsCount: number;
    totalPagesCount: number;
}

class OverviewListResponse {
    messageList: MessageList;
    status: string;
    page: OverviewListPage;
}
