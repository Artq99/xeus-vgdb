class OverviewListItem {
    gameId: number;
    title: string;
    gameDescription: string;
    releasesCount: number;
    firstReleaseDate: Date;
}

class OverviewListPage {
    overviewList: OverviewListItem[];
    pageNumber: Number;
    pageSize: Number;
    totalItemsCount: Number;
    totalPagesCount: Number;
}

class OverviewListResponse {
    messageList: MessageList;
    status: string;
    page: OverviewListPage;
}
