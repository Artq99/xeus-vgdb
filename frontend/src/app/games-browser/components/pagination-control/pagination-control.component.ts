import { Component, Input, Output, EventEmitter } from "@angular/core";

/**
 * The component that controlls the pagination of the overview list of games.
 */
@Component({
    selector: 'app-pagination-control',
    templateUrl: './pagination-control.component.html'
})
export class PaginationControlComponent {

    @Input() currentPage: number;
    @Input() pagesCount: number;
    @Output() turnPageEvent = new EventEmitter<number>();

    /**
     * The callback for the button 'next'.
     */
    nextPage() {
        if (this.currentPage + 1 < this.pagesCount) {
            this.turnPageEvent.emit(1);
        }
    }

    /**
     * The callback for the button 'previous'.
     */
    previousPage() {
        if (this.currentPage > 0) {
            this.turnPageEvent.emit(-1);
        }
    }
}
